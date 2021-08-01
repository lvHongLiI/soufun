package com.lvhongli.service.impl;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.HouseSubscribeRepertory;
import com.lvhongli.dao.MessageRepository;
import com.lvhongli.model.HouseSubscribe;
import com.lvhongli.model.Message;
import com.lvhongli.model.MessageTypeEnum;
import com.lvhongli.pojo.SubscribeParam;
import com.lvhongli.service.SubscribeService;
import com.lvhongli.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private HouseSubscribeRepertory subscribeRepertory;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Map findAll(SubscribeParam param) {
        Page page = subscribeRepertory.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("userId"), UserUtil.getUser().getId());
                return criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("status"),2));
            }
        }, PageRequest.of(param.getStart(), param.getLength()));
        return new  HashMap(){{
            put("draw",param.getDraw());
            put("recordsTotal",page.getTotalElements());
            put("recordsFiltered",page.getTotalElements());
            put("data",page.getContent());
        }};
    }

    @Transactional
    @Override
    public ResultMsg completeHouse(Integer id) {
        Optional<HouseSubscribe> optional = subscribeRepertory.findById(id);
        if (!optional.isPresent()){
            return ResultMsg.fail("找不到预约记录");
        }
        HouseSubscribe subscribe = optional.get();
        if (subscribe.getStatus()!=2){
            return ResultMsg.fail("当前记录看房已完成");
        }
        subscribe.setStatus(3);
        subscribe.setLastUpdateTime(new Date());
        subscribeRepertory.save(subscribe);
        //2.添加一条消息
        Message message = new Message();
        message.setStatus(false);
        message.setData(subscribe.getHouse().getId().toString());
        message.setUpdateTime(new Date());
        message.setCreateTime(new Date());
        message.setType(MessageTypeEnum.addSubscribeNumber);
        messageRepository.save(message);
        return ResultMsg.success();
    }
}

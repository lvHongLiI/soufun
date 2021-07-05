package com.lvhongli.service.impl;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.HouseRepository;
import com.lvhongli.dao.HouseSubscribeRepertory;
import com.lvhongli.dao.UserRepository;
import com.lvhongli.model.House;
import com.lvhongli.model.HouseSubscribe;
import com.lvhongli.model.User;
import com.lvhongli.service.ClientSubscribeService;
import com.lvhongli.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.Optional;

@Service
public class ClientSubscribeServiceImpl implements ClientSubscribeService {

    @Autowired
    private HouseSubscribeRepertory houseSubscribeRepertory;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserRepository userRepository;
    /**
     * 添加预约
     * @param houseId
     * @return
     */
    @Override
    public ResultMsg addSubscribe(Integer houseId) {
        Optional<House> optional = houseRepository.findById(houseId);
        if (!optional.isPresent()||optional.get().getStatus()!=1){
           return ResultMsg.fail("房源信息已下架");
        }
        House house = optional.get();
        Optional<User> userOptional = userRepository.findById(house.getAdminId());
        if (!userOptional.isPresent()){
          return   ResultMsg.fail("找不到房东信息");
        }
        User user = userOptional.get();
        HouseSubscribe subscribe = new HouseSubscribe();
        subscribe.setUserId(UserUtil.getUser().getId());
        subscribe.setCreateTime(new Date());
        subscribe.setLastUpdateTime(new Date());
        subscribe.setHouse(house);
        subscribe.setStatus(1);
        subscribe.setTelephone(user.getPhoneNumber());
        houseSubscribeRepertory.save(subscribe);
        return ResultMsg.success();
    }

    /**
     * 查询当前用户预约记录
     * @param id
     * @param status
     * @param pageable
     * @return
     */
    @Override
    public ResultMsg query(Integer id, Integer status, Pageable pageable) {
        Page page = houseSubscribeRepertory.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                Predicate predicate = cb.equal(root.get("userId"), id);
                return cb.and(predicate, cb.equal(root.get("status"), status));
            }
        }, pageable);

        return ResultMsg.success(page.get());
    }

    @Transactional
    @Override
    public ResultMsg deleteSubscribe(Integer houseId) {
        houseSubscribeRepertory.deleteSubscribe(UserUtil.getUser().getId(),houseId);
        return ResultMsg.success();
    }
}

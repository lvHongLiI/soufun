package com.lvhongli.service.impl;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.HouseSubscribeRepertory;
import com.lvhongli.pojo.SubscribeParam;
import com.lvhongli.service.SubscribeService;
import com.lvhongli.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private HouseSubscribeRepertory subscribeRepertory;

    @Override
    public Map findAll(SubscribeParam param) {
        Page page = subscribeRepertory.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("userId"), UserUtil.getUser().getId());
            }
        }, PageRequest.of(param.getStart(), param.getLength()));
        return new  HashMap(){{
            put("draw",param.getDraw());
            put("recordsTotal",page.getTotalElements());
            put("recordsFiltered",page.getTotalElements());
            put("data",page.getContent());
        }};
    }
}

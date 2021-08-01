package com.lvhongli.service;

import com.lvhongli.configure.ResultMsg;
import org.springframework.data.domain.Pageable;

public interface ClientSubscribeService {
    
    
    ResultMsg addSubscribe(Integer houseId);

    ResultMsg query(Integer status, Integer id,Pageable pageable);

    ResultMsg deleteSubscribe(Integer houseId);

    ResultMsg subscribeDate(Integer id, String phone, String orderTime);
}

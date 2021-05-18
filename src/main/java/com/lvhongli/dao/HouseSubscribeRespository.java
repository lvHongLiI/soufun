package com.lvhongli.dao;

import com.lvhongli.model.HouseSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




/**
 * Created by 瓦力.
 */
public interface HouseSubscribeRespository extends JpaRepository<HouseSubscribe, Long> {


}

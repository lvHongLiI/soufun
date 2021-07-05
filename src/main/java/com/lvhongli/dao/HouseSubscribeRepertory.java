package com.lvhongli.dao;

import com.lvhongli.model.HouseSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by 瓦力.
 */
public interface HouseSubscribeRepertory extends JpaRepository<HouseSubscribe, Integer>, JpaSpecificationExecutor {

    @Query(value = "SELECT status  FROM house_subscribe h WHERE h.house_id=:houseId and h.user_id=:userId",nativeQuery = true)
    Integer findHouseSubscribeStatus(@Param("houseId")Integer houseId,@Param("userId") Integer userId);


    List<HouseSubscribe> findByUserIdAndStatus(Integer userId,Integer status);

    @Modifying
    @Query(value = "delete  from  house_subscribe   where user_id=:userId and house_id=:houseId",nativeQuery = true)
    int deleteSubscribe(Integer userId, Integer houseId);
}

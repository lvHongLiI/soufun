package com.lvhongli.dao;

import com.lvhongli.model.HouseSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by 瓦力.
 */
public interface HouseSubscribeRepertory extends JpaRepository<HouseSubscribe, Long> {

    @Query(value = "SELECT status  FROM house_subscribe h WHERE h.house_id=:houseId and h.user_id=:userId",nativeQuery = true)
    Integer findHouseSubscribeStatus(@Param("houseId")Long houseId,@Param("userId") Integer userId);
}

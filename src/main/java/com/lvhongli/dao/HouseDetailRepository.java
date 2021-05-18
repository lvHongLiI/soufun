package com.lvhongli.dao;



import com.lvhongli.model.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Created by 瓦力.
 */
public interface HouseDetailRepository extends JpaRepository<HouseDetail, Long> {

    HouseDetail findByHouseId(Long houseId);
}

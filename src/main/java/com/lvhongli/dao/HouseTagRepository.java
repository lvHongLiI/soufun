package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.HouseTag;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Created by 瓦力.
 */
public interface HouseTagRepository extends JpaRepository<HouseTag, Long> {
        List<HouseTag> findAllByHouseId(Long houseId);

        HouseTag findByHouseIdAndName(Long houseId,String name);
}

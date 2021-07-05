package com.lvhongli.dao;


import com.lvhongli.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by 瓦力.
 */
public interface HouseRepository extends JpaRepository<House, Integer> ,JpaSpecificationExecutor {

    @Modifying
    @Query("update House as h  set h.cover=:coverId where h.id=:houseId")
    int updateCover(@Param("coverId") String coverId, @Param("houseId") Integer houseId);
}

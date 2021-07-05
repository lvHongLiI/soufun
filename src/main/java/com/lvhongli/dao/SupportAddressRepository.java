package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.LocalLevelEnum;
import com.lvhongli.model.SupportAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SupportAddressRepository extends JpaRepository<SupportAddress, Integer> {

    List<SupportAddress> findAllByLevel(LocalLevelEnum Level);

    List<SupportAddress> findByPidAndLevel(@Param("pid") Integer pid, @Param("level") LocalLevelEnum level);


    SupportAddress findByIdAndLevel(@Param("id") Integer id, @Param("level") LocalLevelEnum level);

    @Query(value = "select * from support_address where `level`='city'",nativeQuery = true)
    List<SupportAddress> findAllCityPinYin();
}

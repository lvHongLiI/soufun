package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.SupportAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by 瓦力.
 */
public interface SupportAddressRepository extends JpaRepository<SupportAddress, Long> {

    List<SupportAddress> findAllByLevel(String Level);

    List<SupportAddress> findAllByBelongToAndLevel(@Param("belongTo") String belongTo,@Param("level") String level);

    SupportAddress findByEnNameAndLevel(String enName,String Level);

    @Query(value = "select * from support_address where en_name=:enName and level='city'",nativeQuery = true)
    SupportAddress findByEnNameCity(String enName);

    @Query(value = "select * from support_address where en_name=:enName and level='region'",nativeQuery = true)
    SupportAddress findByEnNameRegion(String enName);
}

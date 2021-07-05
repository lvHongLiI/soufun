package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.Subway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SubwayRepository extends JpaRepository<Subway, Long> {


    @Query(value = "select * from subway where support_address_id=:cityId",nativeQuery = true)
    List<Subway> findByCityId(Integer cityId);
}

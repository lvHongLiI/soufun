package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.Subway;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Created by 瓦力.
 */
public interface SubwayRepository extends JpaRepository<Subway, Long> {


    List<Subway> findAllByCityEnName(String cityEnName);
}

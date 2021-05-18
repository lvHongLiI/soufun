package com.lvhongli.dao;



import com.lvhongli.model.SubwayStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by 瓦力.
 */
public interface SubwayStationRepository extends JpaRepository<SubwayStation, Long> {


     List<SubwayStation> findAllBySubwayId(Long SubwayId);
}

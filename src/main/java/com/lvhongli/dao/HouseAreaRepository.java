package com.lvhongli.dao;

import com.lvhongli.model.HouseArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseAreaRepository extends JpaRepository<HouseArea, Long> {

    List<HouseArea> findAllByOrderBySortAsc();
}

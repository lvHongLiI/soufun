package com.lvhongli.dao;



import com.lvhongli.model.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseDetailRepository extends JpaRepository<HouseDetail, Integer> {

    HouseDetail findByHouseId(Integer houseId);
}

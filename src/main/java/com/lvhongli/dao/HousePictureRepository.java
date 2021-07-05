package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.HousePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



public interface HousePictureRepository extends JpaRepository<HousePicture, Integer> {

    List<HousePicture> findAllByHouseId(Integer houseId);
}

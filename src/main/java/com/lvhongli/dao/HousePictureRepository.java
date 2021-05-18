package com.lvhongli.dao;

import java.util.List;

import com.lvhongli.model.HousePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



/**
 * Created by 瓦力.
 */
public interface HousePictureRepository extends JpaRepository<HousePicture, Long> {

    List<HousePicture> findAllByHouseId(Long houseId);
}

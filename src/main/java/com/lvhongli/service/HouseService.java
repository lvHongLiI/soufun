package com.lvhongli.service;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.model.*;
import com.lvhongli.pojo.HouseForm;
import com.lvhongli.pojo.HouseParam;

import java.util.List;
import java.util.Map;

public interface HouseService {

    ResultMsg add(HouseForm house);


    Map findAll(HouseParam param);

    ResultMsg update(Long id, Integer status);

    House findOne(Long id);

    HouseDetail findByDetail(Long id);

    List<HouseTag> findByHouseTag(Long id);

    List<HousePicture> findByHousePicture(Long id);

    SupportAddress findByCity(String cityEnName);

    SupportAddress findByRegion(String regionEnName);

    ResultMsg addTag(HouseTag tag);

    ResultMsg deleteTag(HouseTag tag);

    ResultMsg deletePhoto(Long id);

    ResultMsg cover(String coverId, Long houseId);

    ResultMsg edit(HouseForm houseForm);
}

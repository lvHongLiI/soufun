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

    ResultMsg update(Integer id, Integer status);

    House findOne(Integer id);

    HouseDetail findByDetail(Integer id);

    List<HouseTag> findByHouseTag(Integer id);

    List<HousePicture> findByHousePicture(Integer id);

    SupportAddress findByCity(Integer id);

    SupportAddress findByRegion(Integer id);

    ResultMsg addTag(HouseTag tag);

    ResultMsg deleteTag(HouseTag tag);

    ResultMsg deletePhoto(Integer id);

    ResultMsg cover(String coverId, Integer houseId);

    ResultMsg edit(HouseForm houseForm);
}

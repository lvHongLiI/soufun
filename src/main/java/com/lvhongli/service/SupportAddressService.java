package com.lvhongli.service;

import com.lvhongli.configure.ResultMsg;

public interface SupportAddressService {

//    ResultMsg findAllCity();


    ResultMsg findRegionList(Integer pid);

    ResultMsg findSubwayLine(Integer cityId);

    ResultMsg findSubwayStation(Integer subwayId);

    ResultMsg getCityAll();

    ResultMsg getPinYinCityAll();
}

package com.lvhongli.service;

import com.lvhongli.configure.ResultMsg;

public interface SupportAddressService {

    ResultMsg findAllCity();


    ResultMsg findRegionList(String enName);

    ResultMsg findSubwayLine(String enName);

    ResultMsg findSubwayStation(Long subwayId);
}

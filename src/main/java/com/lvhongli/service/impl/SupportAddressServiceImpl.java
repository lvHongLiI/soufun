package com.lvhongli.service.impl;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.SubwayRepository;
import com.lvhongli.dao.SubwayStationRepository;
import com.lvhongli.dao.SupportAddressRepository;

import com.lvhongli.model.LocalLevelEnum;
import com.lvhongli.model.SupportAddress;
import com.lvhongli.service.SupportAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SupportAddressServiceImpl implements SupportAddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;
    @Autowired
    private SubwayRepository subwayRepository;
    @Autowired
    private SubwayStationRepository subwayStationRepository;

    @Override
    public ResultMsg findRegionList(Integer pid) {
        return ResultMsg.success(supportAddressRepository.findByPidAndLevel(pid,LocalLevelEnum.region));
    }

    @Override
    public ResultMsg findSubwayLine(Integer cityId) {
        return ResultMsg.success(subwayRepository.findByCityId(cityId));
    }

    @Override
    public ResultMsg findSubwayStation(Integer subwayId) {
        return  ResultMsg.success(subwayStationRepository.findAllBySubwayId(subwayId));
    }

    @Override
    public ResultMsg getCityAll() {
        return ResultMsg.success(supportAddressRepository.findAllByLevel(LocalLevelEnum.city));
    }

    @Override
    public ResultMsg getPinYinCityAll() {
        List<SupportAddress> list = supportAddressRepository.findAllByLevel(LocalLevelEnum.city);
        return ResultMsg.success(list.stream().collect(Collectors.groupingBy(SupportAddress::getFristPinYin)));
    }
}

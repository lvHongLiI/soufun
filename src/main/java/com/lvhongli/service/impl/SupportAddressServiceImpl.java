package com.lvhongli.service.impl;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.dao.SubwayRepository;
import com.lvhongli.dao.SubwayStationRepository;
import com.lvhongli.dao.SupportAddressRepository;
import com.lvhongli.service.SupportAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportAddressServiceImpl implements SupportAddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;
    @Autowired
    private SubwayRepository subwayRepository;
    @Autowired
    private SubwayStationRepository subwayStationRepository;
    @Override
    public ResultMsg findAllCity() {
        return ResultMsg.success(supportAddressRepository.findAllByLevel("city"));
    }

    @Override
    public ResultMsg findRegionList(String enName) {
        return ResultMsg.success(supportAddressRepository.findAllByBelongToAndLevel(enName,"region"));
    }

    @Override
    public ResultMsg findSubwayLine(String enName) {
        return ResultMsg.success(subwayRepository.findAllByCityEnName(enName));
    }

    @Override
    public ResultMsg findSubwayStation(Long subwayId) {
        return  ResultMsg.success(subwayStationRepository.findAllBySubwayId(subwayId));
    }
}

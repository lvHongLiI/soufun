package com.lvhongli.service.impl;

import com.google.common.collect.ImmutableMap;
import com.lvhongli.dao.*;
import com.lvhongli.es.ESService;
import com.lvhongli.es.EsHouseDto;
import com.lvhongli.model.*;
import com.lvhongli.pojo.RentSearch;
import com.lvhongli.pojo.RoomConfigEnum;
import com.lvhongli.service.ClientHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ClientHouseServiceImpl implements ClientHouseService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private HouseAreaRepository houseAreaRepository;

    @Autowired
    private RoomConfigRepository roomConfigRepository;

    @Autowired
    private HouseSubscribeRepertory houseSubscribeRepertory;

    @Autowired
    private ESService esService;

    @Override
    public List<Rental> rentalAll() {
       return rentalRepository.findAllByOrderBySort();
    }

    @Override
    public List<SupportAddress> findRegions(Integer pid) {
        return supportAddressRepository.findByPidAndLevel(pid, LocalLevelEnum.region);
    }

    @Override
    public List<HouseArea> findAreas() {
        return houseAreaRepository.findAllByOrderBySortAsc();
    }

    @Override
    public List<RoomConfig> findRoomConfigByType(RoomConfigEnum type) {
        return roomConfigRepository.findAllByTypeOrderBySort(type.name());
    }

    @Override
    public Page search(RentSearch rentSearch) {
        return  esService.search(rentSearch);
    }

    @Override
    public EsHouseDto selectById(Integer id) {
        return esService.searchById(id);
    }

    @Override
    public Integer getSubscribeStatus(Integer houseId, Integer userId) {
        Integer status = houseSubscribeRepertory.findHouseSubscribeStatus(houseId, userId);
        if (status==null){
            status=0;
        }
        return status;
    }

    @Override
    public Long houseCount(EsHouseDto esHouseDto) {
        HashMap<Object, Object> map = new HashMap<>();
        if (esHouseDto.getCityId()!=null)
            map.put("cityId", esHouseDto.getCityId());
        if (esHouseDto.getRegionId()!=null)
            map.put("regionId", esHouseDto.getRegionId());
        if (esHouseDto.getDistrict()!=null)
            map.put("district", esHouseDto.getDistrict());

        return esService.houseCount(map);
    }


}

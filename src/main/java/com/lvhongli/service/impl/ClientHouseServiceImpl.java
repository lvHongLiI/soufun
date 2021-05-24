package com.lvhongli.service.impl;

import com.lvhongli.dao.HouseAreaRepository;
import com.lvhongli.dao.RentalRepository;
import com.lvhongli.dao.RoomConfigRepository;
import com.lvhongli.dao.SupportAddressRepository;
import com.lvhongli.model.HouseArea;
import com.lvhongli.model.Rental;
import com.lvhongli.model.RoomConfig;
import com.lvhongli.model.SupportAddress;
import com.lvhongli.pojo.RoomConfigEnum;
import com.lvhongli.service.ClientHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Rental> rentalAll() {
       return rentalRepository.findAllByOrderBySort();
    }

    @Override
    public List<SupportAddress> findRegions(String belongTo) {
        return supportAddressRepository.findAllByBelongToAndLevel(belongTo,"region");
    }

    @Override
    public List<HouseArea> findAreas() {
        return houseAreaRepository.findAllByOrderBySortAsc();
    }

    @Override
    public List<RoomConfig> findRoomConfigByType(RoomConfigEnum type) {
        return roomConfigRepository.findAllByTypeOrderBySort(type.name());
    }


}

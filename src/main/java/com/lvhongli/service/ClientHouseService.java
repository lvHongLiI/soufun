package com.lvhongli.service;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.es.EsHouseDto;
import com.lvhongli.model.HouseArea;
import com.lvhongli.model.Rental;
import com.lvhongli.model.RoomConfig;
import com.lvhongli.model.SupportAddress;
import com.lvhongli.pojo.RentSearch;
import com.lvhongli.pojo.RoomConfigEnum;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientHouseService {

    List<Rental> rentalAll();

    List<SupportAddress> findRegions(String belongTo);

    List<HouseArea> findAreas();

    List<RoomConfig> findRoomConfigByType(RoomConfigEnum type);

    Page search(RentSearch rentSearch);

    EsHouseDto selectById(Long id);

    Integer getSubscribeStatus(Long id, Integer id1);

    Long houseCount(EsHouseDto esHouseDto);
}

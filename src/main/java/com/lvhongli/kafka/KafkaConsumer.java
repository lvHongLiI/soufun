package com.lvhongli.kafka;

import com.alibaba.fastjson.JSONObject;
import com.lvhongli.dao.SupportAddressRepository;
import com.lvhongli.es.ESRepository;
import com.lvhongli.es.ESService;
import com.lvhongli.es.EsHouseDto;
import com.lvhongli.job.MessageJob;
import com.lvhongli.model.MessageTypeEnum;
import com.lvhongli.pojo.HouseData;
import com.lvhongli.util.UploadUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class KafkaConsumer {

    @Autowired
    private ESService esService;

    @Autowired
    private UploadUtil uploadUtil;

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @KafkaListener(topics ="deleteHouse",groupId = "1")
    public void deleteEsData(ConsumerRecord consumerRecord, Acknowledgment ack){
        esService.deleteById(Integer.valueOf(consumerRecord.value().toString()));
        ack.acknowledge();
    }


    @KafkaListener(topics ="addSubscribeNumber",groupId = "1")
    public synchronized void  addSubscribeNumber(ConsumerRecord consumerRecord, Acknowledgment ack){
        EsHouseDto esHouseDto = esService.searchById(Integer.valueOf(consumerRecord.value().toString()));
        esHouseDto.setWatchPerson(esHouseDto.getWatchPerson()+1);
        System.out.println(esHouseDto);
        esService.update(esHouseDto);
        ack.acknowledge();
    }


    @KafkaListener(topics = "createHouse",groupId = "2")
    public void addEsData(ConsumerRecord consumerRecord, Acknowledgment ack){
        HouseData data = JSONObject.parseObject(consumerRecord.value().toString(), HouseData.class);
        EsHouseDto dto = new EsHouseDto();
        dto.setAdminId(data.getHouse().getAdminId());
        dto.setId(data.getHouse().getId());
        dto.setRoomArea(data.getHouse().getArea());
        dto.setRoomDirection(data.getHouse().getDirection());
        dto.setTitle(data.getHouse().getTitle());
        dto.setCityId(data.getHouse().getCity().getId());
        dto.setRegionId(data.getHouse().getRegion().getId());
        dto.setPrice(data.getHouse().getPrice());
        dto.setRoom(data.getHouse().getRoom());
        dto.setBathroom(data.getHouse().getBathroom());
        dto.setBuildYear(data.getHouse().getBuildYear());
        dto.setFloor(data.getHouse().getFloor());
        dto.setTotalFloor(data.getHouse().getTotalFloor());
        dto.setCover(data.getHouse().getCover());
        dto.setParlour(data.getHouse().getParlour());
        dto.setPrice(data.getHouse().getPrice());
        dto.setLastUpdateTime(data.getHouse().getLastUpdateTime());
        dto.setRoundService(data.getDetail().getRoundService());
        dto.setDescription(data.getDetail().getDescription());
        dto.setTraffic(data.getDetail().getTraffic());
        dto.setSubwayStationName(data.getDetail().getSubwayStationName());
        dto.setSubwayLineName(data.getDetail().getSubwayLineName());
        dto.setRentWay(data.getDetail().getRentWay());
        dto.setLayoutDesc(data.getDetail().getLayoutDesc());
        dto.setDistrict(data.getHouse().getDistrict());
        dto.setDistanceToSubway(data.getHouse().getDistanceToSubway());
        dto.setTags(data.getTags().stream().map(v->v.getName()).collect(Collectors.toList()));
        dto.setPictures(data.getPictures().stream().map(v->v.getPath()).collect(Collectors.toList()));
        esService.create(dto);
        ack.acknowledge();
    }
}

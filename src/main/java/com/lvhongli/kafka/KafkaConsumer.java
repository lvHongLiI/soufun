package com.lvhongli.kafka;

import com.alibaba.fastjson.JSONObject;
import com.lvhongli.es.ESRepository;
import com.lvhongli.es.ESService;
import com.lvhongli.es.EsHouseDto;
import com.lvhongli.job.MessageJob;
import com.lvhongli.pojo.HouseData;
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

    @KafkaListener(topics = MessageJob.delete_topic,groupId = "1")
    public void deleteEsData(ConsumerRecord consumerRecord, Acknowledgment ack){
        esService.deleteById(Long.valueOf(consumerRecord.value().toString()));
        ack.acknowledge();
    }


    @KafkaListener(topics = MessageJob.create_topic,groupId = "2")
    public void addEsData(ConsumerRecord consumerRecord, Acknowledgment ack){
        System.out.println("进来了");
        HouseData data = JSONObject.parseObject(consumerRecord.value().toString(), HouseData.class);
        EsHouseDto dto = new EsHouseDto();
        dto.setId(data.getHouse().getId());
        dto.setRoomArea(data.getHouse().getArea());
        dto.setRoomDirection(data.getHouse().getDirection());
        dto.setTitle(data.getHouse().getTitle());
        dto.setCityEnName(data.getHouse().getCityEnName());
        dto.setRegionEnName(data.getHouse().getRegionEnName());
        dto.setRoom(data.getHouse().getRoom());
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
        dto.setDistanceToSubway(data.getHouse().getDistanceToSubway());
        dto.setTags(data.getTags().stream().map(v->v.getName()).collect(Collectors.toList()));
        dto.setPictures(data.getPictures().stream().map(v->v.getPath()).collect(Collectors.toList()));
        esService.create(dto);
        ack.acknowledge();
    }
}

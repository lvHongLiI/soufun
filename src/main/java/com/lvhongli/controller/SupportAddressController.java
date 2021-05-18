package com.lvhongli.controller;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.service.SupportAddressService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("地址获取接口")
@RestController
@RequestMapping("/supportAddress")
public class SupportAddressController {

    @Autowired
    private SupportAddressService service;

    @GetMapping("/findAllCity")
    public ResultMsg findAllCity(){
        return   service.findAllCity();
    }

    @GetMapping("/findRegionList/{cityEnName}")
    public ResultMsg findRegionList(@PathVariable("cityEnName") String enName){
        return   service.findRegionList(enName);
    }

    @GetMapping("/findSubwayLine/{cityEnName}")
    public ResultMsg findSubwayLine( @PathVariable("cityEnName") String enName){
        return service.findSubwayLine(enName);
    }
    @GetMapping("/findSubwayStation/{subwayId}")
    public ResultMsg findSubwayStation( @PathVariable("subwayId") Long subwayId){
        return service.findSubwayStation(subwayId);
    }
}

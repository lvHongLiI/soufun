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



    @GetMapping("/findRegionList/{pid}")
    public ResultMsg findRegionList(@PathVariable("pid") Integer pid){
        return   service.findRegionList(pid);
    }

    @GetMapping("/findSubwayLine/{cityId}")
    public ResultMsg findSubwayLine( @PathVariable("cityId") Integer cityId){
        return service.findSubwayLine(cityId);
    }

    @GetMapping("/findSubwayStation/{subwayId}")
    public ResultMsg findSubwayStation( @PathVariable("subwayId") Integer subwayId){
        return service.findSubwayStation(subwayId);
    }

    @GetMapping("/getCityAll")
    public ResultMsg getCityAll(){
        return service.getCityAll();
    }


    @GetMapping("/getPinYinCityAll")
    public ResultMsg getPinYinCityAll(){
        return service.getPinYinCityAll();
    }
}

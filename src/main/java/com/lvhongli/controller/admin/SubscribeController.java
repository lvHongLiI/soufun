package com.lvhongli.controller.admin;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.model.HouseSubscribe;
import com.lvhongli.pojo.SubscribeParam;
import com.lvhongli.service.SubscribeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("后台-预约管理api")
@RestController
@RequestMapping("/admin/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @GetMapping("/findAll")
    @ApiOperation(value = "预约管理查询", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "预约管理查询", response = HouseSubscribe.class),
    })
    public Map findAll(SubscribeParam param){
      return   subscribeService.findAll(param);
    }
}

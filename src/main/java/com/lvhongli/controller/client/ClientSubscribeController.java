package com.lvhongli.controller.client;

import com.lvhongli.configure.ResultMsg;
import com.lvhongli.model.HouseSubscribe;
import com.lvhongli.service.ClientSubscribeService;
import com.lvhongli.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/subscribe")
@Api("客户端-用户api")
public class ClientSubscribeController {

    @Autowired
    private ClientSubscribeService service;

    @PostMapping("/{houseId}")
    @ApiOperation(value = "添加预约", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "添加预约", response = String.class),
    })
    public ResultMsg addSubscribe(@PathVariable("houseId") Integer houseId){
        return service.addSubscribe(houseId);
    }

    @DeleteMapping("/{houseId}")
    @ApiOperation(value = "删除预约", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除预约", response = String.class),
    })
    public ResultMsg delete(@PathVariable("houseId") Integer houseId){
        return service.deleteSubscribe(houseId);
    }

    @GetMapping("/query/list/{status}")
    @ApiOperation(value = "查询预约记录", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询预约记录", response = HouseSubscribe.class),
    })
    public ResultMsg query(@PathVariable("status") Integer status, @PageableDefault(page = 0,size = 3) Pageable pageable){
        return service.query(UserUtil.getUser().getId(),status,pageable);
    }

}

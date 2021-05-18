package com.lvhongli.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/user")
@Api("客户端-用户api")
public class ClientUserController {

    @GetMapping("/login")
    @ApiOperation(value = "客户端登录页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "客户端登录页面", response = String.class),
    })
    public String login(){
        return "user/login";
    }


    @GetMapping("/center")
    @ApiOperation(value = "客户端管理首页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "客户端管理首页", response = String.class),
    })
    public String center(){
        System.out.println("进来了");
        return "index";
    }
}

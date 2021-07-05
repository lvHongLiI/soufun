package com.lvhongli.controller.client;

import com.lvhongli.service.SupportAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
@Api("首页")
public class IndexController {

    @Autowired
    private SupportAddressService supportAddressService;

    @Autowired
    private ServletContext servletContext;


    @PostConstruct
    public void init(){
        System.out.println("执行了？");
        servletContext.setAttribute("list",supportAddressService.getPinYinCityAll().getData());
    }


    @GetMapping({"/","/index"})
    @ApiOperation(value = "首页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "首页", response = String.class),
    })
    public String index(){
        return "index";
    }


    @GetMapping("/client/userCenter/index")
    @ApiOperation(value = "用户中心页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "用户中心页面", response = String.class),
    })
    public String userCenterIndex(){
        return "user/center";
    }




    @GetMapping("/client/user/login")
    @ApiOperation(value = "客户端登录页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "客户端登录页面", response = String.class),
    })
    public String login(){
        return "user/login";
    }


    @GetMapping("/client/user/center")
    @ApiOperation(value = "客户端管理首页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "客户端管理首页", response = String.class),
    })
    public String center(Model model){
        return "index";
    }
}

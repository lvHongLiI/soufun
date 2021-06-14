package com.lvhongli.controller.admin;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

    @GetMapping("/admin/house/listHtml")
    public String list(){
        return "admin/house-list";
    }

    @GetMapping("/admin/house/addHtml")
    public String addHtml(){
        return "admin/house-add";
    }


    @GetMapping("/admin/user/center")
    @ApiOperation(value = "系统端管理首页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "系统端管理首页", response = String.class),
    })
    public String center(){
        return "admin/center";
    }


    @GetMapping("/admin/user/login")
    @ApiOperation(value = "系统端登录页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "系统端登录页面", response = String.class),
    })
    public String login(){
        return "admin/login";
    }


    @GetMapping("/admin/user/welcome")
    @ApiOperation(value = "系统端欢迎页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "系统端欢迎页面", response = String.class),
    })
    public String welcome(){
        return "admin/welcome";
    }


    @GetMapping("/admin/house/show")
    @ApiOperation(value = "房源展示页面", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "房源展示页面", response = String.class),
    })
    public String houseShow(Long id){
        return "admin/house-show";
    }



    @GetMapping({"/","/index"})
    @ApiOperation(value = "首页", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "首页", response = String.class),
    })
    public String index(Model model){
        return "index";
    }

}

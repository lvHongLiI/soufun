package com.lvhongli.controller.client;

import com.lvhongli.auth.alipay.AuthContext;
import com.lvhongli.configure.ResultMsg;
import com.lvhongli.service.impl.SystemUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/client/user")
@Api("客户端-用户api")
public class ClientUserController {

    @Autowired
   private SystemUserServiceImpl userService;


    @Autowired
    private AuthContext authContext;

    @GetMapping("/updateInfo")
    @ApiOperation(value = "修改个人信息", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "修改个人信息", response = String.class),
    })
    public ResultMsg updateInfo(Map map){
        return userService.updateInfo(map);
    }

    @GetMapping("/authLogin")
    @ApiOperation(value = "第三方登录", notes = "")
    @ApiResponses({
            @ApiResponse(code = 200, message = "第三方登录"),
    })
    public void  authLogin(String code, String type, HttpServletResponse response) throws IOException {
        authContext.login(code,type,response);
    }
}

package com.lvhongli.controller;

import com.lvhongli.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
class MainsiteErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "/401.html";
        }else if(statusCode == 404){
            if(SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")){
               response.sendRedirect("/client/user/login");
            }
            return "/404.html";
        }else if(statusCode == 403){
            return "/403.html";
        }else{
            return "/500.html";
        }

    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
package com.lvhongli.util;

import com.lvhongli.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.net.URLEncoder;


public class UserUtil {


    public static User getUser(){
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return (User) authenticationToken.getPrincipal();
    }

    public static void main(String[] args) {
        String encode = URLEncoder.encode("https://qjyx.info/home");
        System.out.println(encode);
    }
}

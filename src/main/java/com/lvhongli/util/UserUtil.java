package com.lvhongli.util;

import com.lvhongli.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtil {


    public static User getUser(){
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return (User) authenticationToken.getPrincipal();
    }
}

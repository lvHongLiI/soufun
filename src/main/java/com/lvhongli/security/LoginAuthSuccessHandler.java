package com.lvhongli.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class LoginAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private  LoginUrlEntryPoint entryPoint;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = request.getHeader("Referer");
        if (targetUrl.indexOf("?")!=-1){
            targetUrl=targetUrl.substring(0,targetUrl.indexOf("?"));
        }
        targetUrl=targetUrl.replace("login","center");
        super.setDefaultTargetUrl(targetUrl);
        super.onAuthenticationSuccess(request,response,authentication);
    }
}

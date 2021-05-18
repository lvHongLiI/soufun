package com.lvhongli.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class LoginAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String targetUrl = request.getHeader("Referer");
        if (targetUrl.indexOf("?")!=-1){
            targetUrl=targetUrl.substring(0,targetUrl.indexOf("?"));
        }
        targetUrl+="?authError="+URLEncoder.encode(exception.getMessage(), "UTF-8") ;
        super.setDefaultFailureUrl(targetUrl);
        super.onAuthenticationFailure(request,response,exception);
    }
}

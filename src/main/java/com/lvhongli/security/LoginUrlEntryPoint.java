package com.lvhongli.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private PathMatcher pathMatcher=new AntPathMatcher();

    private final Map<String,String> map;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        map=new HashMap<>();
        //普通用户
        map.put("/client/**","/client/user/login");
        //管理员登录用户
        map.put("/admin/**","/admin/user/login");
    }


    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (pathMatcher.match(entry.getKey(),uri)){
                return entry.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request,response,exception);
    }
}

package com.lvhongli.auth.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.lvhongli.dao.UserRepository;
import com.lvhongli.model.User;
import com.lvhongli.model.UserTypeEnum;
import com.lvhongli.security.WebSecurityAuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/18 16:05
 */
@Component
@Slf4j
public class AlipayAuthHandler implements AuthHandler{

    @Autowired
    private AlipayProperties properties;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityAuthenticationProvider authenticationProvider;

    @Override
    public AuthResult getToken(String code,String refreshToken) {
        AlipayClient alipayClient = new DefaultAlipayClient(properties.getServerUrl(), properties.getAppId(), properties.getPrivateKey(), properties.getFormat(), properties.getCharset(), properties.getPublicKey(), properties.getSignType());
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        if (StringUtils.isEmpty(code)){
            request.setCode(code);
            request.setGrantType("authorization_code");
        }else {
            request.setRefreshToken(refreshToken);
            request.setGrantType("refresh_token");
        }
        try {
            AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
            if ("10000".equals(response.getCode())){
                return new AlipayResult(true,response);
            }
            return new AlipayResult(false,response.getMsg());
        } catch (AlipayApiException e) {
            log.error("调用支付宝获取token失败：{}",e);
            return new AlipayResult(false,"调用支付宝获取token异常");
        }
    }

    @Override
    public AuthResult getUserInfo(String accessToken) {
        AlipayClient alipayClient = new DefaultAlipayClient(properties.getServerUrl(), properties.getAppId(), properties.getPrivateKey(), properties.getFormat(), properties.getCharset(), properties.getPublicKey(), properties.getSignType());
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        try {
            AlipayUserInfoShareResponse response = alipayClient.execute(request, accessToken);
            if ("10000".equals(response.getCode())){
                return new AlipayResult(true,response);
            }
            return new AlipayResult(false,response.getMsg());
        } catch (AlipayApiException e) {
            log.error("调用支付宝获取用户信息失败：{}",e);
            return new AlipayResult(false,"调用支付宝获取用户信息异常");
        }
    }

    @Override
    public void login(String code, HttpServletResponse response) throws IOException {
        AuthResult result=null;
        //1.通过code换token
        result = getToken(code, null);
        if (!result.isSuccess()){
            response.sendRedirect("重定向地址");
            return;
        }
        //2.通过token获取用户信息
        AlipaySystemOauthTokenResponse tokenResponse = (AlipaySystemOauthTokenResponse) result.getData();
        result= getUserInfo(tokenResponse.getAccessToken());
        if (!result.isSuccess()){
            response.sendRedirect("重定向地址");
            return;
        }
        AlipayUserInfoShareResponse shareResponse = (AlipayUserInfoShareResponse) result.getData();
        //3.更新或保存用户信息
        User loginUser = userRepository.findByUsernameAndType(shareResponse.getUserId(), UserTypeEnum.alipay_wallet);
        if (loginUser==null){
            loginUser=new User();
        }
        loginUser.setAvatar(shareResponse.getAvatar());
        loginUser.setNickName(shareResponse.getNickName());
        loginUser.setUsername(shareResponse.getUserId());
        loginUser.setType(UserTypeEnum.alipay_wallet);
        loginUser.setEnabled(true);
        userRepository.save(loginUser);
        //4.生成getAliPayAuthenticate
        SecurityContextHolder.getContext().setAuthentication(authenticationProvider.getAliPayAuthenticate(loginUser));
    }

    @Override
    public String state() {
        return "alipay_wallet";
    }


}

package com.lvhongli.auth.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
}

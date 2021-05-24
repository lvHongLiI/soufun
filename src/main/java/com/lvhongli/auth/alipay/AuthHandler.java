package com.lvhongli.auth.alipay;

/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/18 16:02
 */
public interface AuthHandler {

    AuthResult getToken(String code, String refreshToken);

    AuthResult getUserInfo(String accessToken);
}

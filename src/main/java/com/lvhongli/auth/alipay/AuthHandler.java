package com.lvhongli.auth.alipay;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/18 16:02
 */
public interface AuthHandler {

    AuthResult getToken(String code, String refreshToken);

    AuthResult getUserInfo(String accessToken);

    void login(String code, HttpServletResponse response) throws IOException;

    String state();
}

package com.lvhongli.auth.alipay;

/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/18 16:04
 */
public interface AuthResult<T> {

    boolean isSuccess();

    String message();

    T getData();

    void setData(T t);
}

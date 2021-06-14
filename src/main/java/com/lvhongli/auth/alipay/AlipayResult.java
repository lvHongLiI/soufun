package com.lvhongli.auth.alipay;

/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/18 16:29
 */
public class AlipayResult<T> implements AuthResult<T> {

    private boolean success;

    private String message;

    private T data;

    public AlipayResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public AlipayResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String message() {
        return message;
    }


    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data=data;
    }


}

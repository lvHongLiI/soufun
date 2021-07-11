package com.lvhongli.model;

public enum  UserTypeEnum {

    base("本地用户","base"),

    alipay_wallet("支付宝用户","alipay_wallet");

    String name;

    String code;

    UserTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}

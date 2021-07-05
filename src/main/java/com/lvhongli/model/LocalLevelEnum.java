package com.lvhongli.model;

public enum LocalLevelEnum {
    region("region"), //区县
    city("city"); //城市
    private String code;

    LocalLevelEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

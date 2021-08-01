package com.lvhongli.model;

public enum  MessageTypeEnum {

    createHouse("createHouse"),
    deleteHouse("deleteHouse"),
    addSubscribeNumber("addSubscribeNumber");
    MessageTypeEnum(String code) {
        this.code = code;
    }

    private String code;


}

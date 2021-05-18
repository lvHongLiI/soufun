package com.lvhongli.pojo;

import lombok.Data;

public enum  UploadFileType {

    picture("picture","图片"),
    video("video","视频"),
    audioFrequency("audioFrequency","音频"),
    text("text","文本"),
    office("office","办公文件");

    private String code;

    private String value;



    UploadFileType(String code, String value) {
        this.code = code;
        this.value = value;
    }



    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }


    public static   UploadFileType ofValue(String value){
        for (UploadFileType type : values()) {
            if (type.getValue().equals(value))
                return type;
        }
        return null;
    }
}

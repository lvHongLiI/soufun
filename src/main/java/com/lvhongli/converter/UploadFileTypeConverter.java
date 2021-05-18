package com.lvhongli.converter;

import com.lvhongli.pojo.UploadFileType;

import javax.persistence.AttributeConverter;

public class UploadFileTypeConverter implements AttributeConverter<UploadFileType,String> {
    @Override
    public String convertToDatabaseColumn(UploadFileType uploadFileType) {
        return uploadFileType.getCode();
    }

    @Override
    public UploadFileType convertToEntityAttribute(String s) {
        return UploadFileType.valueOf(s);
    }
}

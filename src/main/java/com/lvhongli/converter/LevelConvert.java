package com.lvhongli.converter;


import com.lvhongli.model.LocalLevelEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
public class LevelConvert implements AttributeConverter<LocalLevelEnum,String> {

    @Override
    public String convertToDatabaseColumn(LocalLevelEnum localLevelEnum) {
        return localLevelEnum.getCode();
    }

    @Override
    public LocalLevelEnum convertToEntityAttribute(String s) {
        LocalLevelEnum levelEnum = LocalLevelEnum.valueOf(s);
        return levelEnum;
    }
}

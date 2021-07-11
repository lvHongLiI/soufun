package com.lvhongli.converter;


import com.lvhongli.model.UserTypeEnum;

import javax.persistence.AttributeConverter;

public class UserTypeConvert implements AttributeConverter<UserTypeEnum,String> {
    @Override
    public String convertToDatabaseColumn(UserTypeEnum typeEnum) {
       return typeEnum.getCode();
    }

    @Override
    public UserTypeEnum convertToEntityAttribute(String s) {
        return UserTypeEnum.valueOf(s);
    }
}

package com.lvhongli.converter;

import com.lvhongli.model.MessageTypeEnum;

import javax.persistence.AttributeConverter;

public class MessageTypeConvert  implements AttributeConverter<MessageTypeEnum,String> {
    @Override
    public String convertToDatabaseColumn(MessageTypeEnum messageTypeEnum) {
        return messageTypeEnum.name();
    }

    @Override
    public MessageTypeEnum convertToEntityAttribute(String s) {
      return   MessageTypeEnum.valueOf(s);
    }
}

package com.lvhongli.pojo;

import lombok.Data;

@Data
public class SubscribeParam {
    //分页
    private Integer draw;

    private Integer start;

    private Integer length;
}

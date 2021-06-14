package com.lvhongli.es;

import com.lvhongli.configure.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EsSearchPojo extends Page {

    @ApiModelProperty(value = "搜索关键词", example = "放租")
    private String keyword;

    @ApiModelProperty(value = "城市", example = "上海")
    private String cityEnName;

    @ApiModelProperty(value = "区域", example = "东圃区")
    private String region;

    @ApiModelProperty(value = "租金范围", example = "0~20")
    private String price;

    @ApiModelProperty(value = "房屋面积", example = "0~90")
    private String roomArea;

    @ApiModelProperty(value = "房型", example = "1")
    private Integer room;

    @ApiModelProperty(value = "户型朝向", example = "北")
    private String roomDirection;

    @ApiModelProperty(value = "租赁方式", example = "整租")
    private String rentalWay;


}

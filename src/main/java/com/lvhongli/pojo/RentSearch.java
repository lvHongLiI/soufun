package com.lvhongli.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class RentSearch {

    @ApiModelProperty(value = "关键字", example = "嘿嘿")
    private String keywords;

    @ApiModelProperty(value = "城市id 如：北京", example = "12")
    private Integer cityId;

    @ApiModelProperty(value = "区县id 如：大恩区", example = "12")
    private Integer regionId;

    @ApiModelProperty(value = "价格范围", example = "0~500")
    private String priceBlock;

    @ApiModelProperty(value = "面积范围", example = "20~50")
    private String areaBlock;

    @ApiModelProperty(value = "房间数", example = "1")
    private Integer room;

    @ApiModelProperty(value = "房屋朝向", example = "1")
    private Integer direction;

    @ApiModelProperty(value = "整租 还是合租", example = "1")
    private Integer rentWay;

    @ApiModelProperty(value = "排序字段", example = "lastUpdateTime")
    private String orderBy = "lastUpdateTime";

    @ApiModelProperty(value = "升序还是降序", example = "desc")
    private String orderDirection = "DESC";

    @ApiModelProperty(value = "起始位置", example = "1")
    private int start = 0;

    @ApiModelProperty(value = "一页多少条", example = "10")
    private int size = 10;
}

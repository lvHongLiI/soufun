package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 瓦力.
 */
@Entity
@Table(name = "house_detail")
@Data
public class HouseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "house_id")
    @ApiModelProperty(value = "房源id", example = "12")
    private Integer houseId;

    @ApiModelProperty(value = "房源描述", example = "等等")
    private String description;

    @ApiModelProperty(value = "房屋介绍", example = "非常牛批的房子")
    @Column(name = "layout_desc")
    private String layoutDesc;

    @ApiModelProperty(value = "交通出行", example = "地铁")
    private String traffic;

    @ApiModelProperty(value = "周边配套", example = "商业大厦")
    @Column(name = "round_service")
    private String roundService;

    @ApiModelProperty(value = "出租方式", example = "1")
    @Column(name = "rent_way")
    private int rentWay;

    @ApiModelProperty(value = "地址", example = "双凤路")
    @Column(name = "address")
    private String detailAddress;

    @ApiModelProperty(value = "地铁id", example = "12")
    @Column(name = "subway_line_id")
    private Long subwayLineId;

    @ApiModelProperty(value = "地铁站id", example = "12")
    @Column(name = "subway_station_id")
    private Long subwayStationId;

    @ApiModelProperty(value = "地铁线名称", example = "1号线")
    @Column(name = "subway_line_name")
    private String subwayLineName;


    @ApiModelProperty(value = "地铁站名称", example = "火车南站")
    @Column(name = "subway_station_name")
    private String subwayStationName;
}

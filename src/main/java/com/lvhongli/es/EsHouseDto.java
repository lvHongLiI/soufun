package com.lvhongli.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

@Data
@Document(indexName = "soufun",type = "house",replicas = 0,createIndex = false)
public class EsHouseDto {

    @ApiModelProperty(value = "房源id", example = "123")
    @Id
    private Long id;

    @ApiModelProperty(value = "房源封面", example = "http://123")
    @Field(type = FieldType.keyword)
    private String cover;

    @ApiModelProperty(value = "标题", example = "牛批的房子")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String title;

    @ApiModelProperty(value = "城市名称", example = "北京")
    @Field(type = FieldType.keyword)
    private String cityEnName;

    @ApiModelProperty(value = "区县名称", example = "东城区")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String regionEnName;

    @ApiModelProperty(value = "所在小区", example = "姜黄花园")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String district;

    @ApiModelProperty(value = "几室", example = "1")
    @Field(type = FieldType.Integer)
    private Integer room;

    @ApiModelProperty(value = "几厅", example = "1")
    @Field(type = FieldType.Integer)
    private Integer parlour;

    @ApiModelProperty(value = "几卫", example = "1")
    @Field(type = FieldType.Integer)
    private Integer bathroom;

    @ApiModelProperty(value = "朝向", example = "1")
    @Field(type = FieldType.Integer)
    private Integer direction;

    @ApiModelProperty(value = "房屋面积 米", example = "12")
    @Field(type = FieldType.Integer)
    private Integer roomArea;

    @ApiModelProperty(value = "房屋所在楼层", example = "12")
    @Field(type = FieldType.Integer)
    private Integer floor;

    @ApiModelProperty(value = "总共楼层", example = "12")
    @Field(type = FieldType.Integer)
    private Integer totalFloor;

    @ApiModelProperty(value = "建筑年份", example = "1970")
    @Field(type = FieldType.Integer)
    private Integer buildYear;

    @ApiModelProperty(value = "地铁线路", example = "1号线")
    @Field(type = FieldType.keyword)
    private String subwayLineName;

    @ApiModelProperty(value = "地铁站点名称", example = "不知道站")
    @Field(type = FieldType.keyword)
    private String subwayStationName;

    @ApiModelProperty(value = "距离地铁多少米", example = "12")
   @Field(type = FieldType.Integer)
    private Integer distanceToSubway;

    @ApiModelProperty(value = "标签", example = "非常牛批的房子")
    @Field(type = FieldType.keyword)
    private List<String> tags;

    @ApiModelProperty(value = "价格", example = "122")
    @Field(type = FieldType.Integer)
    private Integer price;

    @ApiModelProperty(value = "更新时间", example = "2020-02-02")
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "浏览该房源人数", example = "11")
    @Field(type = FieldType.Integer)
    private Integer watchTimes;

    @ApiModelProperty(value = "详情页路径", example = "localhost://")
    @Field(type = FieldType.keyword)
    private String detailPath;

    @ApiModelProperty(value = "详细描述", example = "")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String description;

    @ApiModelProperty(value = "户型介绍", example = "")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String layoutDesc;

    @ApiModelProperty(value = "交通出行", example = "")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String traffic;

    @ApiModelProperty(value = "周边配套", example = "")
    @Field(type = FieldType.text,analyzer = "ik_max_word")
    private String roundService;

    @ApiModelProperty(value = "租赁方式", example = "")
    @Field(type = FieldType.Integer)
    private Integer rentWay;


    @ApiModelProperty(value = "房屋图片路径", example = "")
    @Field(type = FieldType.keyword)
    private List<String> pictures;

    @ApiModelProperty(value = "房屋朝向", example = "")
    @Field(type = FieldType.Integer)
    private Integer roomDirection;

    @ApiModelProperty(value = "看房人数", example = "")
    @Field(type = FieldType.Integer)
    private int watchPerson;

    @ApiModelProperty(value = "管理员id", example = "")
    @Field(type = FieldType.Integer)
    private Integer adminId;


}

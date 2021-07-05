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
@Table(name = "house_picture")
@Data
public class HousePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "房源id", example = "12")
    @Column(name = "house_id")
    private Integer houseId;


    @ApiModelProperty(value = "图片路径", example = "12")
    private String path;


    @ApiModelProperty(value = "图片宽度", example ="12")
    private int width;


    @ApiModelProperty(value = "12", example = "图片高度")
    private int height;


    @ApiModelProperty(value = "图片地址", example = "暂时没用")
    private String location;

}

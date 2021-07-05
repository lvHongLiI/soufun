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
@Table(name = "house_tag")
@Data
public class HouseTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ApiModelProperty(value = "房源id", example = "12")
    @Column(name = "house_id")
    private Integer houseId;


    @ApiModelProperty(value = "标签名称", example = "名称")
    @Column(name = "name")
    private String name;
}

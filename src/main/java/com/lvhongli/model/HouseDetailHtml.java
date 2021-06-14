package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/19 15:29
 */
@Data
public class HouseDetailHtml {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", example = "2")
    private Long id;

    @ApiModelProperty(value = "房源id", example = "123")
    @Column(name = "house_id")
    private Long houseId;


    @ApiModelProperty(value = "文件存储路径", example = "/home/data.jsp")
    @Column(name = "path")
    private Long path;
}

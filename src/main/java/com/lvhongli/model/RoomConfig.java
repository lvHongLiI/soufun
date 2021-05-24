package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room_config")
public class RoomConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ApiModelProperty(value = "名称", example = "0~100")
    private String name;


    @ApiModelProperty(value = "类型 housetype orientations ", example = "")
    private  String type;

    @ApiModelProperty(value = "值", example = "1")
    private  String value;


    @ApiModelProperty(value = "排序值", example = "1")
    private Integer sort;
}

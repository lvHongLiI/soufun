package com.lvhongli.model;

import com.lvhongli.converter.LevelConvert;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by 瓦力.
 */
@Entity
@Table(name = "support_address")
@Data
public class SupportAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @ApiModelProperty(value = "名称", example = "北京市")
    private String name;

    @Column(name = "frist_pin_yin")
    @ApiModelProperty(value = "名称", example = "北京市")
    private String fristPinYin;

    @Column(name = "level")
    @ApiModelProperty(value = "级别", example = "city")
    @Convert(converter = LevelConvert.class)
    private LocalLevelEnum level;

    @Column(name = "baidu_map_lng")
    @ApiModelProperty(value = "经度", example = "154.123")
    private Double baiduMapLongitude;

    @Column(name = "baidu_map_lat")
    @ApiModelProperty(value = "纬度", example = "1233.123")
    private Double baiduMapLatitude;

    @Column(name = "pid")
    @ApiModelProperty(value = "父id", example = "123")
    private Integer pid;

}

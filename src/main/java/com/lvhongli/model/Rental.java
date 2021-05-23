package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "名称", example = "0~100")
    private String name;

    @ApiModelProperty(value = "最小值", example = "123")
    private Integer min;

    @ApiModelProperty(value = "最大值", example = "123")
    private Integer max;

    @ApiModelProperty(value = "排序值", example = "1")
    private Integer sort;
}

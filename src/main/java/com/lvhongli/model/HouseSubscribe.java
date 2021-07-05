package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

import javax.persistence.*;

/**
 * 预约看房实体类
 * Created by 瓦力.
 */
@Entity
@Table(name = "house_subscribe")
@Data
public class HouseSubscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "房源", example = "12")
    @JoinColumn(name = "house_id")
    @OneToOne(fetch = FetchType.EAGER)
    private House house;

    @ApiModelProperty(value = "用户id", example = "12")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成", example = "1")
    private Integer status;

    @ApiModelProperty(value = "创建时间", example = "2020-07-01")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "上次修改时间", example = "2020-07-01")
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "预约时间", example = "2020-07-01")
    @Column(name = "order_time")
    private Date orderTime;

    @ApiModelProperty(value = "手机号", example = "13404034390")
    private String telephone;
//
//    /**
//     * 踩坑 desc为MySQL保留字段 需要加转义
//     */
//    @Column(name = "`desc`")
//    private String desc;

}

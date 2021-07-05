package com.lvhongli.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by 瓦力.
 */
@Entity
@Table(name = "house")
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "房源标题", example = "非常牛批的房源")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "添加房源账户", example = "11")
    @Column(name = "admin_id")
    private Integer adminId;

    @ApiModelProperty(value = "价格", example = "15.23")
    @Column(name = "price")
    private BigDecimal price;

    @ApiModelProperty(value = "面积", example = "123")
    @Column(name = "area")
    private Integer area;

    @ApiModelProperty(value = "房间数", example = "4")
    @Column(name = "room")
    private Integer room;

    @ApiModelProperty(value = "客厅数量", example = "1")
    @Column(name = "parlour")
    private Integer parlour;

    @ApiModelProperty(value = "几卫", example = "1")
    @Column(name = "bathroom")
    private Integer bathroom;

    @ApiModelProperty(value = "所在楼层", example = "15")
    @Column(name = "floor")
    private Integer floor;

    @ApiModelProperty(value = "总楼层", example = "15")
    @Column(name = "total_floor")
    private Integer totalFloor;

    @ApiModelProperty(value = "建筑时间", example = "1999")
    @Column(name = "build_year")
    private Integer buildYear;

    @ApiModelProperty(value = "房源状态  0-未审核 1-审核通过 2-已出租 3-逻辑删除", example = "1")
    @Column(name = "status")
    private Integer status;

    @ApiModelProperty(value = "创建时间", example = "2020-01-01")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "上传修改时间", example = "2020-01-01")
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "城市", example = "北京")
    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private SupportAddress city;

    @ApiModelProperty(value = "上传修改时间", example = "东城区")
    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id")
    private SupportAddress region;

    @ApiModelProperty(value = "所在街道", example = "红牌楼街道")
    @Column(name = "street")
    private String street;

    @ApiModelProperty(value = "所在小区", example = "光明小区")
    @Column(name = "district")
    private String district;

    @ApiModelProperty(value = "朝向", example = "1")
    @Column(name = "direction")
    private Integer direction;

    @ApiModelProperty(value = "封面", example = "4562199+55444")
    @Column(name = "cover")
    private String cover;

    @ApiModelProperty(value = "地铁距离", example = "1888")
    @Column(name = "distance_to_subway")
    private Integer distanceToSubway;

    @ApiModelProperty(value = "带看次数", example = "1")
    @Column(name = "watch_times")
    private Integer watchTimes;

}

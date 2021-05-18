package com.lvhongli.model;

import lombok.Data;

import java.util.Date;

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
@Table(name = "house")
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "admin_id")
    private Long adminId;

    private Integer price;

    private Integer area;

    private Integer room;

    private Integer parlour;

    private Integer bathroom;

    private Integer floor;

    @Column(name = "total_floor")
    private Integer totalFloor;

    @Column(name = "watch_times")
    private Integer watchTimes;

    @Column(name = "build_year")
    private Integer buildYear;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Column(name = "city_en_name")
    private String cityEnName;

    @Column(name = "region_en_name")
    private String regionEnName;

    private String street;

    private String district;

    private Integer direction;

    private String cover;

    @Column(name = "distance_to_subway")
    private Integer distanceToSubway;


}

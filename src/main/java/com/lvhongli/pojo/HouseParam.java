package com.lvhongli.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.Date;

@Data
public class HouseParam {

    //排序
    private String direction;

    private String orderBy;

    //分页
    private Integer draw;

    private Integer start;

    private Integer length;


    //条件
    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTimeMin;

    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTimeMax;

    private Integer  status;

    private String city;

    private String title;
}

package com.lvhongli.model;


import com.lvhongli.converter.MessageTypeConvert;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @ApiModelProperty(value = "类型", example = "create")
    @Convert(converter = MessageTypeConvert.class)
    private MessageTypeEnum type;

    @Column(name = "data")
    @ApiModelProperty(value = "数据", example = "{}")
    private String data;

    @Column(name = "status")
    @ApiModelProperty(value = "状态 false 未发送 true已发送", example = "false")
    private boolean status;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间", example = "2020-02-02 15:11:11")
    private Date createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间", example = "2020-02-02 15:11:11")
    private Date updateTime;

}

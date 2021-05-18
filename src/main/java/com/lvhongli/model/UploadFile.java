package com.lvhongli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lvhongli.converter.UploadFileTypeConverter;
import com.lvhongli.pojo.UploadFileType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "upload_file")
@Data
public class UploadFile {

    @Id
    @GenericGenerator(name = "myGenerator", strategy = "uuid")
    @GeneratedValue(generator = "myGenerator")
    private String id;


    @ApiModelProperty(value = "文件名", example = "什么图片")
    @Column(name = "name")
    private String name;


    @ApiModelProperty(value = "备注", example = "什么图片")
    @Column(name = "remark")
    private String remark;

    @ApiModelProperty(value = "路径", example = "路径")
    @Column(name = "path")
    private String path;



    @ApiModelProperty(value = "文件类型", example = "image/jpeg")
//    @Convert(converter = UploadFileTypeConverter.class)
    @Column(name = "type")
    private String type;


    @ApiModelProperty(value = "文件后缀", example = ".jpg")
    @Column(name = "suffix")
    private String  suffix;


    @ApiModelProperty(value = "状态 0 无效 1 有效", example = "1")
    @Column(name = "valid")
    private boolean valid;


    @Column(name="create_time")
    @ApiModelProperty(value = "创建时间", example = "2019-7-11 10:26")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    @Column(name="update_time")
    @ApiModelProperty(value = "修改时间", example = "2019-7-11 10:26")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}

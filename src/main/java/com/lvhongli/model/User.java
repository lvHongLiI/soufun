package com.lvhongli.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.lvhongli.converter.UserTypeConvert;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by 瓦力.
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID =5715951535681850L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "昵称", example = "嗯嗯")
    @Column(name = "nick_name")
    private String nickName;

    @ApiModelProperty(value = "用户名 ", example = "嗯嗯")
    @Column(name = "user_name")
    private String username;

    @ApiModelProperty(value = "密码（md5 加密）", example = "123445")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "邮箱", example = "1556282924@qq.com")
    @Column(name = "email")
    private String email;

    @ApiModelProperty(value = "手机号码", example = "13404034390")
    @Column(name = "phone_number")
    private String phoneNumber;

    @ApiModelProperty(value = "是否开启", example = "true")
    @Column(name = "enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "用户类型", example = "base")
    @Column(name = "type")
    @Convert(converter = UserTypeConvert.class)
    private UserTypeEnum type;

    @ApiModelProperty(value = "创建时间", example = "2020-08-05")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "上次登录时间", example = "2020-08-05")
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @ApiModelProperty(value = "上次修改时间", example = "2020-08-05")
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @ApiModelProperty(value = "头像", example = "http://1233")
    @Column(name = "avatar")
    private String avatar;

}

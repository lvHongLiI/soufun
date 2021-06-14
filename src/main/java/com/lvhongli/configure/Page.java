package com.lvhongli.configure;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @Title: Page.java 
 * @Package com.amt.configure 
 * @Description: TODO(分页参数配置) 
 * @author 江伟  
 * @date 2018年11月1日 下午4:11:33 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Data
public class Page implements Serializable {

	//@Fields serialVersionUID :  
	private static final long serialVersionUID = -5895715951535681850L;

	// 当前页
	@ApiModelProperty(value = "页码" ,example = "1")
	private Integer offset;
	
	// 每页的数量
	@ApiModelProperty(value = "每页的数量",example = "10")
	private Integer limit;

}

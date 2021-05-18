package com.lvhongli.configure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Title: ResultMsg.java 
 * @Package com.amt.configure 
 * @Description: TODO(信息返回通用配置) 
 * @author 江伟  
 * @date 2018年11月21日 上午11:45:22 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@ApiModel(value = "ResultMsg", description = "消息返回类")
@ApiIgnore
@Data
public class ResultMsg {

	// 状态码
	@ApiModelProperty("状态码")
	private Integer status;
	
	// 消息内容
	@ApiModelProperty("消息内容")
	private String message;
	
	//权限令牌
	@ApiModelProperty("权限令牌")
	private String token;
	
	//返回数据
	@ApiModelProperty("返回数据")
	private Object data;

	private static ResultMsg success;
	private static ResultMsg fail;
	static {
		success=new ResultMsg(200,"成功",null,null);
		fail=new ResultMsg(201,"失败",null,null);
	}

	public ResultMsg(Integer status, String message, String token, Object data) {
		this.status = status;
		this.message = message;
		this.token = token;
		this.data = data;
	}

	public static ResultMsg success(){
		return success;
	}

	public static <T> ResultMsg success(T t){
		return new  ResultMsg(200,"成功",null,t);
	}

	public static <T> ResultMsg success(T t,String token){
		return new  ResultMsg(200,"成功",token,t);
	}


	public static ResultMsg fail(){
		return fail;
	}

	public static ResultMsg fail(String message){
		return new ResultMsg(201,message,null,null);
	}


	public static ResultMsg error(String message){
		return new ResultMsg(500,message,null,null);
	}
}

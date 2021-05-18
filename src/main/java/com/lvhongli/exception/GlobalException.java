package com.lvhongli.exception;

import com.lvhongli.configure.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Title: GlobalException.java 
 * @Package com.amt.exception 
 * @Description: TODO(全局异常处理类) 
 * @author 吕宏力
 * @date 2018年11月21日 上午11:38:39 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@CrossOrigin
@RestControllerAdvice
@Slf4j
public class GlobalException {
	
	/**
	 * @description: 组装异常信息
	 * @param e
	 * @return
	 */
	private String errorTrackSpace(Exception e) {
        StringBuffer sb = new StringBuffer();
        if (e != null) {
            for (StackTraceElement element : e.getStackTrace()) {
                sb.append("\r\n\t").append(element);
            }
        }
        return sb.length() == 0 ? null : sb.toString();
	}
	
	/**
	 * @description: 空指针校验
	 * @param e
	 */
	@ExceptionHandler(value = NullPointerException.class)
	public ResultMsg nullPointerExceptionHandler(NullPointerException e) {
		log.error("exception toString and track space : {}", "\r\n" + e);
		log.error(errorTrackSpace(e));
		return ResultMsg.error( "系统异常");
	}


	/**
	 * @description: 系统错误校验
	 * @param e
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public ResultMsg runtimeExceptionHandler(RuntimeException e) {
		log.error("exception toString and track space : {}", "\r\n" + e);
		log.error(errorTrackSpace(e));
		return ResultMsg.error("系统运行出错");
	}


	/**
	 * @description: 参数错误校验
	 * @param e
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResultMsg httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
		log.error("exception toString and track space : {}", "\r\n" + e);
		log.error(errorTrackSpace(e));
		return  ResultMsg.error( "请求参数类型或格式错误");
	}


}

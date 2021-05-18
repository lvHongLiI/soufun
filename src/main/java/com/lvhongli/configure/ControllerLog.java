package com.lvhongli.configure;

import java.lang.annotation.*;

/**
 * @Title: ControllerLog.java 
 * @Package com.amt.configure 
 * @Description: TODO(Controller层日志配置) 
 * @author 江伟  
 * @date 2018年11月1日 下午5:17:08 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
	String value()  default "";
}

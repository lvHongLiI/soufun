package com.lvhongli.configure;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import lombok.extern.slf4j.Slf4j;

/**
 * @Title: SystemAspect.java
 * @Package com.lvhongli.configure
 * @Description: TODO(系统切点配置类)
 * @author 江伟
 * @date 2018年11月1日 下午5:10:27
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Aspect
@Component
@Slf4j
public class SystemAspect {
	/**
	 * @description: Controller层切点
	 */
	@Pointcut("@annotation(com.lvhongli.configure.ControllerLog)")
	public void controllerAspect() {

	}



	/**
	 * @description: 前置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint
	 */
	@Before(value = "controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		this.save(request, joinPoint, null);
	}


	/**
	 * @description: 保存日志内容
	 * @param request
	 * @param joinPoint
	 * @param e
	 */
	public void save(HttpServletRequest request, JoinPoint joinPoint, Throwable e) {
		//请求的IP
		String ip = getIpAddress(request);
		try {
			// 获取用户请求方法的参数并序列化为JSON格式字符串, 自带的HttpServletRequest, HttpServletResponse不管
			StringBuffer params = new StringBuffer();
			if (null != joinPoint.getArgs() && joinPoint.getArgs().length > 0) {
				for (Object o : joinPoint.getArgs()) {
					if (o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
						continue;
					}
					params.append(JSON.toJSONString(o)).append(";");
				}
			}

			// 控制台输出
			log.info("=======================通知开始=======================");
			StringBuffer methodSB = new StringBuffer();
			methodSB.append(joinPoint.getTarget().getClass().getName()).append(".").append(joinPoint.getSignature().getName()).append("()");
			if(null != e) {
				log.info("异常代码:{}", e.getClass().getName());
				log.info("异常信息:{}", e);
				log.info("异常方法:{}", methodSB.toString());
				log.info("异常参数:{}", params.toString());
			}
			log.info("方法描述:{}", getMethodDescription(joinPoint));
			log.info("请求方法:{}", methodSB.toString());
			log.info("请求参数:{}", params.toString());
			log.info("请求IP:{}", ip);
			log.info("=======================通知结束=======================");
		} catch (Exception e1) {
			//记录本地异常日志
			log.error("前置通知异常信息:{}", e1);
			log.info("=======================通知结束=======================");
		}
	}


	/**
	 * @Description: 获取注解中对方法的描述信息 用于Controller层注解
	 * @param @param joinPoint 切点
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String getMethodDescription(JoinPoint joinPoint)  throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class<?>[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(ControllerLog. class).value();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * @description: 获取用户ip
	 * @param request 请求类
	 * @return ip
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}

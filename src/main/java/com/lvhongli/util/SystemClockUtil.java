package com.lvhongli.util;

/**
 * @Title: SystemClockUtil.java 
 * @Package com.amt.util 
 * @Description: TODO(高并发场景下System.currentTimeMillis()的性能问题的优化工具类) 
 * @author 吕宏li
 * @date 2019年7月9日 下午5:18:40 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class SystemClockUtil {

	public static long get(){
		return System.nanoTime();
	}
 
}

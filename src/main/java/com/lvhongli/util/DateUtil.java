package com.lvhongli.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: DateUtil.java 
 * @Package com.amt.util
 * @Description: TODO(日期工具类) 
 * @author 江伟  
 * @date 2018年11月21日 下午2:59:27 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Slf4j
public class DateUtil {
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String YEAR_MONTH_PATTERN = "yyyy-MM";
	public static final String YEAR_PATTERN = "yyyy";
	public static final String TIME_PATTERN = "HH:mm:ss";
	/**
	 * @description: 获取当前YYYY格式时间
	 */
	public static String getYear() {
		return formatDate(new Date(), YEAR_PATTERN);
	}

	/**
	 * @description: 获取指定日期的 YYYY格式时间
	 * @param date 日期
	 */
	public static String getYear(Date date) {
		return formatDate(date, YEAR_PATTERN);
	}

	/**
	 * @description: 获取当前 YYYY-MM-DD格式时间
	 */
	public static String getDay() {
		return formatDate(new Date(), DATE_PATTERN);
	}

	/**
	 * @description: 根据时间格式内容将字符串转换日期
	 * @param date 日期字符串
	 * @param pattern 格式内容
	 * @return Date
	 */
	public static Date getDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = sdf.parse(date);
        } catch (ParseException e) {
            log.error("日期解析异常:{}",e);
        }
        return newDate;
    }
	
	/**
	 * @description: 将日期字符串转换成指定格式日期字符串
	 * @param date 日期字符串
	 * @param pattern 格式内容
	 * @return Date
	 */
	public static String getStrDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = sdf.parse(date);
        } catch (ParseException e) {
            log.error("日期异常:{}",e);
        }
        return sdf.format(newDate);
    }
	
	/**
	 * @description: 将日期转换成指定格式日期
	 * @param date 日期
	 * @param pattern 格式内容
	 * @return Date
	 */
	public static Date getDateByDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            log.error("日期解析异常:{}",e);
        }
        return date;
    }
	
	/**
	 * @description: 将日期转换成指定格式字符串
	 * @param date 日期
	 * @param pattern 格式内容
	 * @return String
	 */
	public static String getDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
	
	/**
	 * @description: 获取指定日期 YYYY-MM-DD格式时间
	 * @param date 日期
	 */
	public static String getDay(Date date) {
		return formatDate(date, DATE_PATTERN);
	}

	/**
	 * @Description: 获取当前时间 yyyyMMdd格式 
	 * @return String    返回类型
	 */
	public static String getDays() {
		return formatDate(new Date(), "yyyyMMdd");
	}

	/**
	 * @Description: 获取YYYYMMDD格式
	 * @param date
	 * @return String    返回类型
	 */
	public static String getDays(Date date) {
		return formatDate(date, "yyyyMMdd");
	}

	/**
	 * @Description: 获取当前时间 YYYY-MM-DD HH:mm:ss格式
	 * @return String    返回类型
	 */
	public static String getTime() {
		return formatDate(new Date(), DATE_TIME_PATTERN);
	}

	/**
	 * @Description: 获取当前时间 YYYY-MM-DD HH:mm:ss.SSS格式 
	 * @return String    返回类型
	 */
	public static String getMsTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * @Description: 获取当前时间yyyyMMddHHmmss格式
	 * @return String    返回类型
	 */
	public static String getAllTime() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}
	
	/**
	 * @description: 获取时效时间
	 * @param dataStr 当前时间yyyyMMddHHmmss格式
	 * @param number 失效分钟数
	 * @return
	 */
	public static String getExpireTime(String dataStr, int number) {
		String aDataStr = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = sdf.parse(dataStr);
			date.setTime(date.getTime() + number * 60 * 1000);
			aDataStr = sdf.format(date);
		} catch (ParseException e) {
			log.error("获取时效时间异常", e);
		}
		return aDataStr;
	}
	

	/**
	 * @Description: 获取YYYY-MM-DD HH:mm:ss格式
	 * @param date
	 * @return String    返回类型
	 */
	public static String getTime(Date date) {
		return formatDate(date, DATE_TIME_PATTERN);
	}

	/**
	 * @Description: 获取当前时间，不包含年月日
	 * @Return java.lang.String    返回类型
	 */
	public static String getShortTime() {
		String t = formatDate(new Date(), DATE_TIME_PATTERN);
		String time = t.substring(t.indexOf(" "), t.length());
		return time;
	}

	/**
	 * @description: 格式化 制定日期  默认格式yyyy-MM-dd
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (StringUtils.isNotBlank(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, DATE_PATTERN);
		}
		return formatDate;
	}

	/**
	 * @Description: 日期比较，如果s>=e 返回true 否则返回false
	 * @param s
	 * @param e
	 * @return boolean    返回类型
	 */
	public static boolean compareDate(String s, String e) {
		if (parseDate(s) == null || parseDate(e) == null) {
			return false;
		}
		return parseDate(s).getTime() >= parseDate(e).getTime();
	}

	/**
	 * @Description: 格式化日期，默认格式yyyy-MM-dd
	 * @param date
	 * @return Date    返回类型
	 */
	public static Date parseDate(String date) {
		return parse(date,DATE_PATTERN);
	}

	/**
	 * @Description: 格式化日期，默认格式yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return Date    返回类型
	 */
	public static Date parseTime(String date) {
		return parse(date,DATE_TIME_PATTERN);
	}

	/**
	 * @Description: 格式化日期
	 * @param date
	 * @param pattern
	 * @return Date    返回类型
	 */
	public static Date parse(String date, String pattern) {
		try {
			return DateUtils.parseDate(date,pattern);
		} catch (ParseException e) {
			log.error(date, e);
			return null;
		}
	}

	/**
	 * @Description: 格式化日期
	 * @param date
	 * @param pattern
	 * @return String    返回类型
	 */
	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * @Description: 把日期转换为Timestamp
	 * @param date
	 * @return Timestamp    返回类型
	 */
	public static Timestamp format(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * @Description: 校验日期是否合法，格式yyyy-MM-dd HH:mm:ss
	 * @param s
	 * @return boolean    返回类型
	 */
	public static boolean isValidDate(String s) {
		return parse(s, DATE_TIME_PATTERN) != null;
	}

	/**
	 * @Description: 校验日期是否合法 
	 * @param s
	 * @param pattern
	 * @return boolean    返回类型
	 */
	public static boolean isValidDate(String s, String pattern) {
        return parse(s, pattern) != null;
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat(DATE_PATTERN);
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(
					startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * @Description: 时间相减得到天数
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long    返回类型
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			log.error("时间相减得到天数异常：",e);
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * @Description: 得到n天之后的日期 
	 * @param days
	 * @return String    返回类型
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat(DATE_TIME_PATTERN);
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * @Description: 得到n天之后是周几
	 * @param days
	 * @return String    返回类型
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * @Description: 格式化Oracle Date 
	 * @param args
	 * @return void    返回类型
	 */
/*	public static String buildDateValue(Object value){
		if(Func.isOracle()){
			return "to_date('"+ value +"','yyyy-mm-dd HH24:MI:SS')";
		}else{
			return Func.toStr(value);
		}
	}*/

	/**
	 *  时间转换: 如果是今天，返回时间  如果是昨天，返回“昨天”，否则返回月-日
	 * @param date
	 * @return
	 */
	public static String getDateStrByRule(Date date){
		//今天
		if (getDay().equals(getDay(date)))
			return formatDate(date,"HH:mm");
		//昨天
		if (getDaySub(getDay(),getDay(date)) == 1)
			return "昨天";
		return formatDate(date,"MM-dd");
	}

	/**
	 * @description: 计算 年龄
	 * @param birthDay 出生日期格式 yyyy-MM-dd
	 * @throws Exception
	 */
	public static int getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("非法的出生日期！");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}
	 
	 /**
	  * @description: 计算年龄
	  * @param idcard 身份证号码
	  * @throws Exception
	  */
	 public static int getAge(String idcard) throws Exception{
		 Date time = getBirthday(idcard);
		 return getAge(time);
	 }
	 
	 /**
	  * @description: 获取昨天时间，格式yyyy-MM-dd
	  * @return 
	  */
	 public static String getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date date = cal.getTime();
		SimpleDateFormat sdfd = new SimpleDateFormat(DATE_PATTERN);
		return sdfd.format(date);
	 }
	 
	 /**
	  * @description: 根据身份证号获取医院标准的年龄
	  * @param idcard 身份证号
	  * @return 年龄 大于等于12个月，返回 xx岁 
	  * 			小于12个月大于1个月，返回xx月
	  * 			小于1个月大于一日，返回xx天
	  */
	 public static String getAgeForHospital(String idcard) {
		 Date time = getBirthday(idcard);
		 return getAgeForHospital(time);
	 }

	 /**
	  * @description: 获取出生日期
	  * @param idcard 身份证号
	  * @return 出生日期，格式yyyy-MM-dd
	  */
	public static Date getBirthday(String idcard) {
		StringBuilder sb = new StringBuilder();
		 sb.append(idcard.substring(6,10)).append("-").append(idcard.substring(10,12)).append("-").append(idcard.substring(12,14));
		 Date time = DateUtil.parse(sb.toString(),DATE_PATTERN);
		return time;
	}
	
	/**
	 * @description: 两个时间相差的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDaysByDate(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}
	 
	 /**
	  * @description: 获取出生日期医院标准的年龄
	  * @param birthDay 出生日期，格式：yyyy-MM-dd 
	  * @return 年龄 大于等于12个月，返回 xx岁 
	  * 			小于12个月大于1个月，返回xx月
	  * 			小于1个月大于一日，返回xx天
	  */
	 public static String getAgeForHospital(Date birthDay) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("非法的出生日期！");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		int month = age * 12 + (monthNow - monthBirth);
		if (month >= 12) {
			if (monthNow <= monthBirth) {
				if (monthNow == monthBirth) {
					if (dayOfMonthNow < dayOfMonthBirth)
						age--;
				} else {
					age--;
				}
			}
			return age + "岁";
		} else if (month < 12 && month >= 1) {
			if (dayOfMonthNow < dayOfMonthBirth)
				month --;
			if (month == 0) {
				return differentDaysByDate(birthDay, new Date()) + "天";
			}
			return month + "月";
		} else if (month < 1) {
			int day = dayOfMonthNow - dayOfMonthBirth;
			return day + "天";
		}
		return null;
	 }
	 
	 /**
	  * @description: 获取月的天数
	  * @param date 日期
	  * @return 天数
	  */
	public static int getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	 
	public static String getAfterDayDateDay(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat(DATE_PATTERN);
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	
	/**
	 * @description: 获取当前时间 yyyy-MM-dd
	 * @return
	 */
	public static String getDate() {
        return getDate(new Date());
    }

	/**
	 * @description: 获取当前时间 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    public static Date getDate(String date) {
        return getDate(date, DATE_PATTERN);
    }

    public static Date getDateTime(String date) {
        return getDate(date, DATE_TIME_PATTERN);
    }

    public static String getDate(Date date) {
        return getDate(date, DATE_PATTERN);
    }
 
    public static String getDateTime(Date date) {
        return getDate(date, DATE_TIME_PATTERN);
    }
	  
}

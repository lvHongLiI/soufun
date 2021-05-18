package com.lvhongli.configure;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Title: DruidConfig.java 
 * @Package com.amt.configure 
 * @Description: TODO(druid配置类，druid的注册 。包含多个数据源的注册；分布式事务管理器的注册；) 
 * @author 江伟  
 * @date 2019年7月2日 下午5:19:39 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Configuration
public class DruidConfig {
	
	/**
	 * @description: 定义数据源writeDataSource
	 * @param env
	 * @return
	 */
	@Bean(name = "writeDataSource",destroyMethod = "close",initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource")
    @Autowired
	public DataSource writeDataSource(Environment env) {
        return new DruidDataSource();
	}

	

 
    /**
     * @description: druid控制台权限配置
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //控制台管理用户，加入下面2行 进入druid后台就需要登录
        servletRegistrationBean.addInitParameter("loginUsername", "yjyadmin");
        servletRegistrationBean.addInitParameter("loginPassword", "qjyxyjy");
        return servletRegistrationBean;
    }
 
    /**
     * @description: 注册过滤器bean
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }
 
    /**
     * @description: 注入druid查询过滤器
     * @return
     */
    @Bean
    public StatFilter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true); //slowSqlMillis用来配置SQL慢的标准，执行时间超过slowSqlMillis的就是慢。
        statFilter.setMergeSql(true); //SQL合并配置
        statFilter.setSlowSqlMillis(6000);//slowSqlMillis的缺省值为3000，也就是3秒。
        return statFilter;
    }
 
    /**
     * @description: 注入druid多sql查询过滤器
     * @return
     */
    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        //允许执行多条SQL
        WallConfig config = new WallConfig();
        config.setMultiStatementAllow(true);
        wallFilter.setConfig(config);
        return wallFilter;
    }

}

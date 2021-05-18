 //package com.lvhongli.configure;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import javax.sql.DataSource;
//
///**
// * @Title: WriteDataSourceConfig.java
// * @Package com.amt.configure
// * @Description: TODO(写入数据库配置类)
// * @author 江伟
// * @date 2019年1月24日 上午10:20:58
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
// */
//@Configuration
////精确到 mapper 目录，以便跟其他数据源隔离
//@MapperScan(basePackages = {"com.lvhongli.dao"}, markerInterface = MyBaseMapper.class, sqlSessionFactoryRef = "sqlSessionFactory")
//public class WriteDataSourceConfig {
//	@Autowired
//    @Qualifier("writeDataSource")
//    private DataSource ds;
//
//	/**
//	 * @description: sqlSession工厂
//	 * @return
//	 * @throws Exception
//	 */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(ds);
//        //指定mapper xml目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*/*.xml"));
//        return factoryBean.getObject();
//
//    }
//
//    /**
//     *配置相应事物管理器
//     * @return
//     */
//    @Bean(name = "writeDBManager")
//    public DataSourceTransactionManager testTransactionManager() {
//        return new DataSourceTransactionManager(ds);
//    }
//
//    /**
//     * @description: sqlsession模版
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory()); // 使用上面配置的Factory
//        return template;
//    }
//
//
//}

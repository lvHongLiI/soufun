package com.lvhongli.configure;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Swagger2.java
 * @Package com.amt.configure
 * @Description: TODO(Swagger2插件配置类)
 * @author 江伟
 * @date 2018年11月1日 下午4:38:14 Copyright (c) ©1994-2018 Scjydz.com All Rights
 *       Reserved.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	// 文档开关
	@Value("${swagger.production}")
	private boolean enable;

	/**
	 * @description: 文档@ApiOperation注解来给API增加说明、
	 *               通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).enable(enable).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build()
				.globalOperationParameters(this.setHeaderToken());

	}

	/**
	 * @description: 版本信息备注
	 */
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().contact("jiangwei").title("CCB MINIPROGRAM SERVICE API").description("建行小程序接口文档")
				.termsOfServiceUrl("http://www.scjydz.com").version("1.0").build();
	}

	/**
	 * @description: 设置自定义参数
	 */
	private List<Parameter> setHeaderToken() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<>();
		tokenPar.name("accessToken").description("权限码").modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build();
		pars.add(tokenPar.build());
		return pars;
	}

	 

}

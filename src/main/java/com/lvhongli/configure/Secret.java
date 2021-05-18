package com.lvhongli.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Title: Secret.java 
 * @Package com.amt.configure 
 * @Description: TODO(密钥参数配置类) 
 * @author 江伟  
 * @date 2019年1月24日 下午5:19:06 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Component
@ConfigurationProperties("secret")
@Data
public class Secret {
	// 密钥
	private String key;
	// JWT的签发者，是否使用是可选的
	private String issuer;
	// JWT所面向的用户，是否使用是可选的
	private String subject;
	// 失效时间
	private Long ttlMillis;
	// 后台失效时间
	private Long bttlMillis;
	// 公钥
	private String publicKey;
	// 系统私钥
	private String privateKey;
	// 前端私钥
	private String clientPrivateKey;

}

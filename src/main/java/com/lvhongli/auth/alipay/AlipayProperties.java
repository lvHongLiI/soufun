package com.lvhongli.auth.alipay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 吕宏力
 * @Description: TODO(用一句话描述该文件)
 * @date 2021/5/18 16:12
 */
@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayProperties {

    private String serverUrl;

    private String appId;

    private String privateKey;

    private String publicKey;

    private String signType;

    private String charset;

    private String format;


}

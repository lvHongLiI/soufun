package com.lvhongli.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class RedisSessionConfig {

    @Value("${redis.hostname}")
    private  String hostName;

    @Value("${redis.port}")
    private  Integer port;
    @Bean
    public RedisConnectionFactory redisStandaloneMasterConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostName, port);
        RedisConnectionFactory lettuceConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        return lettuceConnectionFactory;
    }

}

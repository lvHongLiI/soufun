package com.lvhongli.configure;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.util.CollectionUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;


@Slf4j
@Configuration
@EnableElasticsearchRepositories("com.lvhongli.es")
public class ESConfiguration  {



    /**
     * es集群地址
     */
    @Value("#{'${elasticsearch.ip}'.split(',')}")
    private List<String> hostName;
    /**
     * 端口
     */
    @Value("${elasticsearch.port}")
    private Integer port;
    /**
     * 集群名称
     */
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${elasticsearch.pool}")
    private String poolSize;

    private TransportClient client;



    /**
     * 初始化配置
     *
     * @return
     */
    private Settings settings() {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("thread_pool.search.size", Integer.parseInt(poolSize))// 增加线程池个数，暂时设为5
                .put("client.transport.sniff", false).build();
        return settings;
    }

    @Bean
    protected TransportClient buildClient() {
        TransportClient transportClient = new PreBuiltTransportClient(settings());

        if (!CollectionUtils.isEmpty(hostName)) {
            hostName.stream().forEach(h -> {
                try {
                    transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(h), port));

                } catch (UnknownHostException e) {
                    log.error("Error addTransportAddress,with host:{}.", h);
                }
            });
        }
        return transportClient;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        Client client = buildClient();
        return new ElasticsearchTemplate(client);
    }
}

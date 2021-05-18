package com.lvhongli;

import com.lvhongli.security.LoginUrlEntryPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@Slf4j
public class SoufunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoufunApplication.class, args);
        log.info("搜房网项目启动了");
    }

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
//    return (container -> {
//        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/templates/401.html");
//        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/templates/404.html");
//        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/templates/500.html");
//        container.addErrorPages(error401Page, error404Page, error500Page);
//    });
//    }

    @Bean
    public LoginUrlEntryPoint loginUrlEntryPoint(){
       return new LoginUrlEntryPoint("/client/user/login");
    }
}

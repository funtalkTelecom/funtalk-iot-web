package com.funtalk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.funtalk"})
@EnableAsync
@MapperScan(basePackages = "com.funtalk.mapper")
@EnableScheduling

public class SpringbootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        System.out.println("====================独立tomcat启动中=====================");
        return application.sources(SpringbootApplication.class);

    }

    public static void main(String[] args) {
        System.out.println("====================内置tomcat启动中=====================");
//    	SpringApplication.run(SpringbootApplication.class, args);
    }

}

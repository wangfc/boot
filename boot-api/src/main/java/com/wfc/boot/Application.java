package com.wfc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableTransactionManagement
//@MapperScan( basePackages = "com.wfc.boot.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        System.out.println(1122);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

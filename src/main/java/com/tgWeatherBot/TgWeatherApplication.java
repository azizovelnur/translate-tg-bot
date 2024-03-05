package com.tgWeatherBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class TgWeatherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TgWeatherApplication.class, args);
    }

}

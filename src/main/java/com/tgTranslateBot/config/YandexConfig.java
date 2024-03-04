package com.tgTranslateBot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class YandexConfig {
    @Value("${yandex.token}")
    private String token;
}

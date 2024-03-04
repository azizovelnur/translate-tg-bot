package com.tgTranslateBot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class YandexConfig {
    @Value("${yandex.token}")
    private String token;
}

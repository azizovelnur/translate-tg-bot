package com.tgWeatherBot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
@Data
public class BotConfig {
    @Value("${bot.userNameOfBot}")
    String usernameOfBot;

    @Value("${bot.token}")
    String token;
}
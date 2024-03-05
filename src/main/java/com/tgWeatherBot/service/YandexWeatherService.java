package com.tgWeatherBot.service;

import com.tgWeatherBot.model.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexWeatherService {
    private final YandexRemoteClient yandexRemoteClient;

    public WeatherResponse.Response getWeather() {
        return yandexRemoteClient.getWeather();
    }
}

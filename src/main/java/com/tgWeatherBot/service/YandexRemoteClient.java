package com.tgWeatherBot.service;


import com.tgWeatherBot.config.FeignConfig;
import com.tgWeatherBot.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "yandexRemoteClient",
        url = "https://api.weather.yandex.ru/v2",
        configuration = FeignConfig.class
)

@Service
public interface YandexRemoteClient {
    @GetMapping(value = "/forecast?lat=40.4093&lon=49.8671&limit=1")
    WeatherResponse.Response getWeather();
}

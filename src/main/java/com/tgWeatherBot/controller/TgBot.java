package com.tgWeatherBot.controller;

import com.tgWeatherBot.config.BotConfig;
import com.tgWeatherBot.model.WeatherResponse;
import com.tgWeatherBot.service.YandexWeatherService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TgBot extends TelegramLongPollingBot {
    public final BotConfig botConfig;
    private final YandexWeatherService yandexWeatherService;

    public TgBot(BotConfig botConfig, YandexWeatherService yandexWeatherService) {
        super(botConfig.getToken());
        this.botConfig = botConfig;
        this.yandexWeatherService = yandexWeatherService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            var username = update.getMessage().getChat().getFirstName();
            var msg = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();
            switch (msg) {
                case "/start":
                    startCommand(chatId, username);
                    break;
                case "/getweather":
                    getWeather(chatId);
                    break;
            }
        }
    }

    private void startCommand(long chatId, String name) {
        String answer = "Haiii😊 " + name;
        sendMessage(chatId, answer);
    }


    private void getWeather(long chatId) {
        WeatherResponse.Response weatherInfo = yandexWeatherService.getWeather();
        sendMessage(chatId, String.valueOf(weatherInfo.fact().temp()));
    }

    private void setKeyboardMarkup(SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("/start");
        row.add("/getweather");
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage(String.valueOf(chatId), text);
        setKeyboardMarkup(message);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUsernameOfBot();
    }
}

package com.tgTranslateBot.controller;

import com.tgTranslateBot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TgBot extends TelegramLongPollingBot {
    public final BotConfig botConfig;
    public TgBot(BotConfig botConfig) {
        super(botConfig.getToken());
        this.botConfig = botConfig;
    }
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("tewtew");
        if (update.hasMessage() && update.getMessage().hasText()) {
            String msg = update.getMessage().getText();
        }
    }
    @Override
    public String getBotUsername() {
        return botConfig.getUsernameOfBot();
    }
}

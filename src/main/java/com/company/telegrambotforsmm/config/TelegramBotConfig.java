package com.company.telegrambotforsmm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBotConfig extends TelegramLongPollingBot {
    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("hello");
            sendMsg(sendMessage);
        }
    }

    public void sendMsg(Object obj) {
        try {
            if (obj instanceof SendMessage) execute((SendMessage) obj);
            else if (obj instanceof SendPhoto) execute((SendPhoto) obj);
            else if (obj instanceof SendVideo) execute((SendVideo) obj);
            else if (obj instanceof SendLocation) execute((SendLocation) obj);
            else if (obj instanceof SendVoice) execute((SendVoice) obj);
            else if (obj instanceof SendContact) execute((SendContact) obj);
            else if (obj instanceof EditMessageText) execute((EditMessageText) obj);
            else if (obj instanceof SendDocument) execute((SendDocument) obj);
            else if (obj instanceof DeleteMessage) execute((DeleteMessage) obj);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

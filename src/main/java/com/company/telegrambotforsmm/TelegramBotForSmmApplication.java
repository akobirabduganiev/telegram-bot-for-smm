package com.company.telegrambotforsmm;

import com.company.telegrambotforsmm.config.TelegramBotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegramBotForSmmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotForSmmApplication.class, args);
    }

}

package com.guessgame.config;

import com.guessgame.GuessCount;
import com.guessgame.MaxNumber;
import com.guessgame.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.guessgame")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}") // <-- значение по умолчанию
    private int maxNumber;
    @Value("${game.minNumber:0}")
    private int minNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MaxNumber // позволяет заменять название бина.
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber // позволяет заменять название бина.
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}

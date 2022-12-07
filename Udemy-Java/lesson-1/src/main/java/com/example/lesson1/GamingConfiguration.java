package com.example.lesson1;

import com.example.lesson1.game.GameRunner;
import com.example.lesson1.game.GamingConsole;
import com.example.lesson1.game.Pacman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new Pacman();
        return game;
    }


    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}

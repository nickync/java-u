package com.example.lesson1;

import com.example.lesson1.game.GameRunner;
import com.example.lesson1.game.MarioGame;
import com.example.lesson1.game.Pacman;
import com.example.lesson1.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var pacman = new Pacman();
        var gameRunner = new GameRunner(pacman);
        gameRunner.run();
    }
}

package com.example.lesson1.game;

public class Pacman implements GamingConsole{
    @Override
    public void up() {
        System.out.println("go up");
    }

    @Override
    public void down() {
        System.out.println("go down");
    }

    @Override
    public void right() {
        System.out.println("go right");
    }

    @Override
    public void left() {
        System.out.println("go left");
    }
}

package com.example.lesson1;

import com.example.lesson1.game.GameRunner;
import com.example.lesson1.game.GamingConfiguration;
import com.example.lesson1.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

        context.getBean(GamingConsole.class).up();

        context.getBean(GameRunner.class).run();
    }
}

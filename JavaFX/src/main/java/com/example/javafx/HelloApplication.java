package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);

//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Label greeting = new Label("Welcome to JavaFX");
        greeting.setTextFill(Color.GREEN);
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root,300, 275));
        root.getChildren().add(greeting);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
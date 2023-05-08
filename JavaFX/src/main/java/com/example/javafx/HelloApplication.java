package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//
////        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        Label greeting = new Label("Welcome to JavaFX");
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 70));

        stage.setTitle("Hello!");
        stage.setScene(new Scene(root,800, 600));
//        root.getChildren().add(greeting);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
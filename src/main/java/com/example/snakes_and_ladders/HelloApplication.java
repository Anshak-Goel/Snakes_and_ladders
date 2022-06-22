package com.example.snakes_and_ladders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("OpeningScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),700,550);
        stage.setScene(scene);
        stage.setTitle("Snakes and Ladders: Done By Deeptorshi Mondal (2020294) and Anshak Goel (2020283)");
        stage.setWidth(700);
        stage.setHeight(550);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
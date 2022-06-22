package com.example.snakes_and_ladders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OpeningController {

    @FXML
    TextField one_id;
    @FXML
    TextField two_id;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void startGame(ActionEvent e) throws IOException{
        String user1 = one_id.getText();
        String user2 = two_id.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        HelloController cont = loader.getController();
        cont.showNames(user1,user2);
        stage =(Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root,500,750);
        stage.setScene(scene);
        stage.setWidth(550);
        stage.setHeight(650);
        stage.show();
    }
}

package com.example.snakes_and_ladders;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class WinningController {
    @FXML
     private Label winlabel;
    @FXML
    private Label loselabel;

    public void declare_result(String n1, String n2,boolean who){
        if(who){
            winlabel.setTextFill(Color.DEEPSKYBLUE);
            loselabel.setTextFill(Color.DARKGREEN);
        }else{
            winlabel.setTextFill(Color.DARKGREEN);
            loselabel.setTextFill(Color.DEEPSKYBLUE);
        }
        winlabel.setText(n1);
        loselabel.setText(n2);
    }
}

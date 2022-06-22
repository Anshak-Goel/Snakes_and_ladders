package com.example.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TimehandlerSL implements EventHandler<ActionEvent> {
    private final double deltaX;
    private final double deltaY;
    private  boolean to_move;
    private HelloController instance;

    TimehandlerSL(double deltaX, double deltaY,boolean to_move,HelloController instance){
        this.to_move = to_move;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.instance = instance;
    }
    @Override
    public void handle(ActionEvent event){
        instance.move_delta_on_XY(deltaX,deltaY,to_move);
    }
}

package com.example.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Timehandler implements EventHandler<ActionEvent> {

    private HelloController main_game;
    private final double delta;
    private  boolean to_move;

    Timehandler(double delta, HelloController main_game,boolean to_move){
        this.to_move = to_move;
        this.delta = delta;
        this.main_game = main_game;
    }
    @Override
    public void handle(ActionEvent event){
        this.main_game.move_delta_on_X(delta,to_move);
    }
}

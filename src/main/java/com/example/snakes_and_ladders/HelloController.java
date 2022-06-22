package com.example.snakes_and_ladders;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.HashMap;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    protected ImageView maindice;

    @FXML
    private Button roll;

    @FXML
    private ImageView arrow;

    @FXML
    private Circle bluecircle;

    @FXML
    private Circle greencircle;

    @FXML
    protected ImageView blue;

    @FXML
    protected  ImageView green;

    @FXML
    private AnchorPane main;
    private Stage stage;
    private Scene scene;
    private Parent root;


    private boolean blue_turn = true;

    private int blue_coor = 0;
    private int green_coor = 0;
    private Roll_die rolling;

    private Glow glow1;

    private ArrayList<Integer> x_coord;
    private ArrayList<Integer> y_coord;
    private HashMap<Integer, ArrayList<ArrayList<Integer>>> snakes_hash;
    private HashMap<Integer, ArrayList<ArrayList<Integer>>> ladders_hash;


    public void initialize(URL arg0, ResourceBundle arg1) {
        glow1 = new Glow(0.8);
        rolling = new Roll_die(this);
        FillData fill= new FillData();
        x_coord = fill.getX_coord();
        y_coord = fill.getY_coord();
        snakes_hash = fill.getSnakes_hash();
        ladders_hash = fill.getLadders_hash();
    }


    public void showNames(String name1, String name2){
        this.name1.setText(name1);
        this.name2.setText(name2);
    }
    public boolean is_at_snake(int val) {
        if (snakes_hash.containsKey(val)) {
            return true;
        }
        return false;
    }

    public boolean is_at_ladder(int val) {
        if (ladders_hash.containsKey(val)) {
            return true;
        } else {
            return false;
        }
    }

    private int getRow(int pos){
        if(pos/10==0 || pos==10){
            return 1;
        }else{
            if(pos%10==0){
                return pos/10;
            }else{
                return (pos/10)+1;
            }
        }
    }

    public int[] return_coordinates(int pos, int row) {
        int[] ret = new int[2];
        if (row % 2 == 0) {
            int xpos = 0, ypos = 0;
            if (pos % 10 == 0) {
                ret[0] = x_coord.get(0);
                ret[1] = y_coord.get((pos / 10) - 1);
            } else {
                xpos = pos % 10;
                ypos = pos / 10;
                ret[0] = x_coord.get(10 - xpos);
                ret[1] = y_coord.get(ypos);
            }
        } else {
            int xpos = 0, ypos = 0;
            if (pos >= 10) {
                if (pos % 10 == 0) {
                    ret[0] = x_coord.get(9);
                    ret[1] = y_coord.get((pos / 10) - 1);
                } else {
                    xpos = pos % 10;
                    ypos = pos / 10;
                    ret[0] = x_coord.get(xpos - 1);
                    ret[1] = y_coord.get(ypos);
                }
            } else {
                ret[1] = y_coord.get(0);
                ret[0] = x_coord.get(pos - 1);
            }
        }
        return ret;
    }

    private void endsenene() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WinningScene.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WinningController cont = loader.getController();
        if(blue_turn){
            cont.declare_result(name1.getText(),name2.getText(),true);
        }else{
            cont.declare_result(name2.getText(),name1.getText(),false);
        }

        stage =(Stage)(main.getScene().getWindow());
        scene = new Scene(root,700,550);
        stage.setScene(scene);
        stage.setWidth(700);
        stage.setHeight(550);
        stage.show();
    }

    public void move_with_transitions(int curr, int die_val, boolean blue_turn){
        int time_delay=0;
        if(curr+die_val>100){
            return;
        }
        if(curr+die_val==100){
            move_only_on_X(curr,die_val,blue_turn);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            endsenene();
        }
        if((curr+die_val)%10==0){
            move_only_on_X(curr, die_val, blue_turn);
            time_delay = 1000;
        }else if(curr%10==0){
            time_delay = move_start_with_Y(curr,die_val,blue_turn);
        }else if((curr+die_val)%10>(curr)%10){
            move_only_on_X(curr,die_val,blue_turn);
            time_delay = 1000;
        }else if((curr+die_val)%10==1){
            move_ending_on_Y(curr,die_val,blue_turn);
            time_delay = 1000;
        }else{
            move_X_followed_by_Y(curr,die_val,blue_turn);
            time_delay=1200;
        }
        int to_check = curr+die_val;
        if(snakes_hash.containsKey(to_check)){
            snake_animations(to_check,blue_turn,time_delay);
        }else if(ladders_hash.containsKey(to_check)){
            ladder_animations(to_check,blue_turn,time_delay);
        }
    }

    private int move_start_with_Y(int curr, int die_val, boolean blue_turn) {
        int co1 = return_coordinates(curr,getRow(curr))[1];
        int co2 = return_coordinates(curr+1,getRow(curr+1))[1];
        int co3 = return_coordinates(curr+1,getRow(curr+1))[0];
        int co4 = return_coordinates(curr+die_val,getRow(curr+die_val))[0];
        double delta_y = (double)(co2-co1)/(double)40;
        double delta_x = (double) (co4-co3)/(double) 100;
        Timeline ofY;
        Timeline ofX;
        KeyFrame move_on_y = new KeyFrame(Duration.millis(5),new TimehandlerY(delta_y,this,blue_turn));
        ofY = new Timeline(move_on_y);
        ofY.setCycleCount(40);
        ofY.play();
        if(die_val!=1){
            KeyFrame move_on_x = new KeyFrame(Duration.millis(10),new Timehandler(delta_x,this,blue_turn));
            ofX = new Timeline(move_on_x);
            ofX.setCycleCount(100);
            ofX.setDelay(Duration.millis(200));
            ofX.play();
            return 1200;
        }
        return 200;
    }

    private void move_X_followed_by_Y(int curr, int dieVal, boolean blue_turn) {
        int move_x_initial;
        move_x_initial = ((10)-(curr%10));
        //0.5,0.2,0.5
        int d11 = return_coordinates(curr,getRow(curr))[0];
        int d12 = return_coordinates(curr+move_x_initial,getRow(curr))[0];
        int d21 = return_coordinates(curr+move_x_initial,getRow(curr))[1];
        int d22 = return_coordinates(curr+move_x_initial+1,getRow(curr)+1)[1];
        int d31 = return_coordinates(curr+move_x_initial+1,getRow(curr)+1)[0];
        int d32 = return_coordinates(curr+dieVal,getRow(curr+dieVal))[0];
        double delta_initial = (double)(d12-d11)/(double)50;
        double delta_Y = (double)(d22-d21)/(double)40;
        double delta_final = (double)(d32-d31)/(double)50;
        Timeline move_on_x_initial;
        KeyFrame moveframe1 = new KeyFrame(Duration.millis(10),new Timehandler(delta_initial,this,blue_turn));
        move_on_x_initial = new Timeline(moveframe1);
        move_on_x_initial.setCycleCount(50);
        move_on_x_initial.play();
        Timeline move_on_y;
        KeyFrame moveframe2 = new KeyFrame(Duration.millis(5),new TimehandlerY(delta_Y,this,blue_turn));
        move_on_y = new Timeline(moveframe2);
        move_on_y.setCycleCount(40);
        move_on_y.setDelay(Duration.millis(500));
        move_on_y.play();
        Timeline move_on_x_final;
        KeyFrame moveframe3 = new KeyFrame(Duration.millis(10),new Timehandler(delta_final,this,blue_turn));
        move_on_x_final = new Timeline(moveframe3);
        move_on_x_final.setCycleCount(50);
        move_on_x_final.setDelay(Duration.millis(700));
        move_on_x_final.play();
    }

    private void move_ending_on_Y(int curr, int die_val, boolean blue_turn) {
        if(curr%10==0){
            int y_prev = return_coordinates(curr+die_val-1,getRow(curr+die_val-1))[1];
            int y = return_coordinates(curr+die_val,getRow(curr+die_val))[1];
            double deltaY = (double) (y-y_prev)/(double)100;
            Timeline move_on_y;
            KeyFrame moveframeY = new KeyFrame(Duration.millis(10),new TimehandlerY(deltaY,this,blue_turn));
            move_on_y = new Timeline(moveframeY);
            move_on_y.setCycleCount(100);
            move_on_y.play();
        }else{
            int x_prev = return_coordinates(curr,getRow(curr))[0];
            int x = return_coordinates(curr+die_val-1,getRow(curr+die_val-1))[0];
            double delta = (double) (x-x_prev)/(double)100;
            Timeline move_on_x;
            KeyFrame moveframe = new KeyFrame(Duration.millis(8),new Timehandler(delta,this,blue_turn));
            move_on_x = new Timeline(moveframe);
            move_on_x.setCycleCount(100);
            move_on_x.play();
            int y_prev = return_coordinates(curr+die_val-1,getRow(curr+die_val-1))[1];
            int y = return_coordinates(curr+die_val,getRow(curr+die_val))[1];
            double deltaY = (double) (y-y_prev)/(double)40;
            Timeline move_on_y;
            KeyFrame moveframeY = new KeyFrame(Duration.millis(5),new TimehandlerY(deltaY,this,blue_turn));
            move_on_y = new Timeline(moveframeY);
            move_on_y.setCycleCount(40);
            move_on_y.setDelay(Duration.millis(800));
            move_on_y.play();
        }
    }

    private void move_only_on_X(int curr, int die_val, boolean blue_turn) {
            int x_prev = return_coordinates(curr,getRow(curr))[0];
            int x = return_coordinates(curr+die_val,getRow(curr+die_val))[0];
            double delta = (double) (x-x_prev)/(double)100;
            Timeline move_on_x;
            KeyFrame moveframe = new KeyFrame(Duration.millis(10),new Timehandler(delta,this,blue_turn));
            move_on_x = new Timeline(moveframe);
            move_on_x.setCycleCount(100);
            move_on_x.play();
    }

    private void snake_animations(int val,boolean blue_turn,int time_delay){
        int count=0;
        ArrayList<ArrayList<Integer>> s_cord = snakes_hash.get(val);
        for(int i=0;i<s_cord.size();i++){
            if(i==0){
                int[] p = return_coordinates(val,getRow(val));
                double delX = (double)(s_cord.get(0).get(0)-p[0])/(double)40;
                double delY = (double)(s_cord.get(0).get(1)-p[1])/(double)40;
                Timeline myTemp;
                KeyFrame kf = new KeyFrame(Duration.millis(5),new TimehandlerSL(delX,delY,blue_turn,this));
                myTemp = new Timeline(kf);
                myTemp.setCycleCount(40);
                myTemp.setDelay(Duration.millis(time_delay));
                count++;
                myTemp.play();
            }else{
                double delX = (double)(s_cord.get(i).get(0)-s_cord.get(i-1).get(0))/(double)40;
                double delY = (double)(s_cord.get(i).get(1)-s_cord.get(i-1).get(1))/(double)40;
                Timeline myTemp;
                KeyFrame kf = new KeyFrame(Duration.millis(5),new TimehandlerSL(delX,delY,blue_turn,this));
                myTemp = new Timeline(kf);
                myTemp.setCycleCount(40);
                myTemp.setDelay(Duration.millis(time_delay+200*count));
                count++;
                myTemp.play();
            }
        }
        UpdatingData inst= new UpdatingData(val);
        int cor = inst.getFinal_cord();
        if(blue_turn){
            blue_coor = cor;
        }else{
            green_coor = cor;
        }
    }

    private void ladder_animations(int val,boolean blue_turn,int time_delay){
        int count=0;
        ArrayList<ArrayList<Integer>> l_cord = ladders_hash.get(val);
        for(int i=0;i<l_cord.size();i++){
            if(i==0){
                int[] p = return_coordinates(val,getRow(val));
                double delX = (double)(l_cord.get(0).get(0)-p[0])/(double)40;
                double delY = (double)(l_cord.get(0).get(1)-p[1])/(double)40;
                Timeline myTemp;
                KeyFrame kf = new KeyFrame(Duration.millis(5),new TimehandlerSL(delX,delY,blue_turn,this));
                myTemp = new Timeline(kf);
                myTemp.setCycleCount(40);
                myTemp.setDelay(Duration.millis(time_delay));
                count++;
                myTemp.play();
            }else{
                double delX = (double)(l_cord.get(i).get(0)-l_cord.get(i-1).get(0))/(double)40;
                double delY = (double)(l_cord.get(i).get(1)-l_cord.get(i-1).get(1))/(double)40;
                Timeline myTemp;
                KeyFrame kf = new KeyFrame(Duration.millis(5),new TimehandlerSL(delX,delY,blue_turn,this));
                myTemp = new Timeline(kf);
                myTemp.setCycleCount(40);
                myTemp.setDelay(Duration.millis(time_delay+200*count));
                count++;
                myTemp.play();
            }
        }
        UpdatingData inst= new UpdatingData(val);
        int cor = inst.getFinal_cord();
        if(blue_turn){
            blue_coor = cor;
        }else{
            green_coor = cor;
        }
    }


    protected void move_delta_on_XY(double delX,double delY,boolean blue_turn) {
        if (blue_turn) {
            blue.setX(blue.getX() + delX);
            blue.setY(blue.getY() + delY);
        } else {
            green.setX(green.getX() + delX);
            green.setY(green.getY() + delY);
        }
    }

        Image die_img1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dice_1.png")));
        Image die_img2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dice_2.png")));
        Image die_img3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dice_3.png")));
        Image die_img4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dice_4.png")));
        Image die_img5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dice_5.png")));
        Image die_img6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dice_6.png")));
        Image arrowimg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("garrow.png")));

        public void move_delta_on_X(double delta,boolean blue_turn){
            if(blue_turn){
                blue.setX(blue.getX()+delta);
            }else{
                green.setX(green.getX()+delta);
            }
        }

        public void move_delta_on_Y(double delta,boolean blue_turn){
            if(blue_turn){
                blue.setY(blue.getY()+delta);
            }else{
                green.setY(green.getY()+delta);
            }
        }

        public void die_animation () {
            rolling.start();
            disablebutton(true);
        }

        public void real_rolling () {
            Random random = new Random();
            int die_num = 0;
            while (true) {
                die_num = random.nextInt(7);
                if (die_num != 0) {
                    if (die_num == 1) {
                        maindice.setImage(die_img1);
                    } else if (die_num == 2) {
                        maindice.setImage(die_img2);
                    } else if (die_num == 3) {
                        maindice.setImage(die_img3);
                    } else if (die_num == 4) {
                        maindice.setImage(die_img4);
                    } else if (die_num == 5) {
                        maindice.setImage(die_img5);
                    } else {
                        maindice.setImage(die_img6);
                    }
                    arrow.setImage(arrowimg);
                    making_move(die_num);
                    return;
                }
            }
        }

        public void making_move ( int die_num){
            if (blue_turn) {
                if (blue_coor == 0 && die_num == 1) {
                    blue.setX(x_coord.get(0) - 21);
                    blue.setY(y_coord.get(0) - 370);
                    blue_coor = 1;
                } else if (blue_coor != 0) {
                    if (blue_coor + die_num <= 100) {
                        int temporary = blue_coor;
                        move_with_transitions(blue_coor, die_num, true);
                        if(temporary==blue_coor){
                            blue_coor += die_num;
                        }
                        if(blue_coor==64){
                            blue_coor=60;
                        }
                        if(blue_coor==92){
                            blue_coor=88;
                        }
                    }
                }
            } else {
                if (green_coor == 0 && die_num == 1) {
                    green.setX(x_coord.get(0) - 21);
                    green.setY(y_coord.get(0) - 340);
                    green_coor = 1;
                } else if (green_coor != 0) {
                    if (green_coor + die_num <= 100) {
                        int temporary = green_coor;
                        move_with_transitions(green_coor, die_num, false);
                        if(temporary==green_coor) {
                            green_coor += die_num;
                        }
                        if(green_coor==64){
                            green_coor=60;
                        }
                        if(green_coor==92){
                            green_coor=88;
                        }
                    }
                }
            }
            blue_turn = !blue_turn;
        }


        public void die_roll (ActionEvent e){
            Path path = new Path();
            path.getElements().add(new MoveTo(30,0));
            path.getElements().add(new VLineTo(100));
            PathTransition transition = new PathTransition();
            transition.setNode(arrow);
            transition.setDuration(Duration.seconds(1.5));
            transition.setPath(path);
            transition.setCycleCount(PathTransition.INDEFINITE);
            transition.play();
            if(!blue_turn){
                bluecircle.setFill(Color.BLUE);
                name1.setDisable(false);
                name1.setEffect(glow1);
                name2.setDisable(true);
                greencircle.setFill(Color.GREY);
            }else{
                bluecircle.setFill(Color.GREY);
                name1.setDisable(true);
                name2.setDisable(false);
                name2.setEffect(glow1);
                greencircle.setFill(Color.GREEN);
            }
            if (blue_coor == 100 || green_coor == 100) {
                disablebutton(true);
                return;
            }
            arrow.setImage(null);
            die_animation();
        }

        public void disablebutton ( boolean bool){
            roll.setDisable(bool);
        }

    }



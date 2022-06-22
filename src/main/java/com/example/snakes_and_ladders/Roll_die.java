package com.example.snakes_and_ladders;

import javafx.animation.AnimationTimer;

import java.util.Random;

public class Roll_die extends AnimationTimer {
    private final long FPS = 50L;
    private final long Interval = 1000000000L / FPS;
    private long end = 0;
    private int count = 0;
    private HelloController controller;

    Roll_die(HelloController controller){
        this.controller = controller;
    }

    @Override
    public void handle(long curr) {
        if (curr - end > Interval) {
            Random random = new Random();
            int number = random.nextInt(7);
            setimage(number);
            end = curr;
            count++;
            if (count > 20) {
                this.stop();
                controller.real_rolling();
                count = 0;
                controller.disablebutton(false);
            }
        }
    }

    public void setimage(int i) {
        if (i == 1) {
            controller.maindice.setImage(controller.die_img1);
        } else if (i == 2) {
            controller.maindice.setImage(controller.die_img2);
        } else if (i == 3) {
            controller.maindice.setImage(controller.die_img3);
        } else if (i == 4) {
            controller.maindice.setImage(controller.die_img4);
        } else if (i == 5) {
            controller.maindice.setImage(controller.die_img5);
        } else {
            controller.maindice.setImage(controller.die_img6);
        }
    }
}

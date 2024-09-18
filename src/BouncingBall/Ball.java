package BouncingBall;

import Doctrina.Canvas;

import java.awt.*;
import java.util.Random;

public class Ball {

    private static final int DEFAULT_SPEED = 5 ;
    private int radius = 25 ;
    private int speed;
    private int x ;
    private int y ;
    private int dx ;
    private int dy ;

    Ball(int radius, int speed){
        this.radius = radius;
        this.speed = speed;
        initializePosition();
    }
    Ball(int radius){
        this.radius = radius;
        this.speed = DEFAULT_SPEED;
        initializePosition();
    }
    public void update(){
        x += dx;
        y += dy;
        if(hasTouchedVertical()){
            dy *= -1;
        }
        if(hasTouchedHorizontal()){
            dx *= -1;
        }
    }

    public boolean hasTouch(){
        return hasTouchedHorizontal()
                || hasTouchedVertical();
    }
    public void draw(Canvas canvas){

        canvas.drawCircle(x,y,radius,Color.RED);

    }

    private void initializePosition(){

         x = randomNumber(radius * 2, 800 - radius *  2);
         y = randomNumber(radius * 2, 600 - radius *  2);
         dx = randomNumber(0,1) == 0 ? DEFAULT_SPEED : -DEFAULT_SPEED;
         dy = randomNumber(0,1) == 0 ? DEFAULT_SPEED : -DEFAULT_SPEED;
    }

    private boolean hasTouchedVertical(){
        return y<= radius || y >= 600-radius;
    }
    private boolean hasTouchedHorizontal(){
        return x<= radius || x >= 800-radius;
    }


    private int randomNumber(int min,int max){
        return new Random().nextInt((max-min)+1)+min;
    }
}

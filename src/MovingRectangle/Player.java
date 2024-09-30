package MovingRectangle;

import Doctrina.Canvas;
import Doctrina.Controller;

import java.awt.*;

public class Player {
    private GamePad controller;
    private int x;
    private int y;

    private int speed;

    public Player(GamePad controller){
        this.controller = controller;
        x = 200;
        y = 200;
        speed = 3;
    }

    public void update(){
        if (controller.isDownPressed()){
            y += speed;
        }
        if (controller.isUpPressed()){
            y -= speed;
        }
        if (controller.isRightPressed()){
            x += speed;
        }
        if (controller.isLeftPressed()){
            x -= speed;
        }

    }
    public void draw(Canvas canvas){
        canvas.drawRectangle(x,y,20,40, Color.WHITE);
    }
}

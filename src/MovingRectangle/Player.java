package MovingRectangle;

import Doctrina.Canvas;

import java.awt.*;
import java.util.SplittableRandom;

public class Player {
    private Controller controller;
    private int x;
    private int y;

    private int speed;

    public Player(Controller controller){
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

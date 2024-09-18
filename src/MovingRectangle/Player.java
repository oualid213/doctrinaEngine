package MovingRectangle;

import Doctrina.Canvas;

import java.awt.*;
import java.util.SplittableRandom;

public class Player {

    private int x;
    private int y;

    private int speed;

    public Player(){
        x = 200;
        y = 200;
        speed = 3;
    }

    public void update(){
        x += speed;
    }
    public void draw(Canvas canvas){
        canvas.drawRectangle(x,y,20,40, Color.WHITE);
    }
}

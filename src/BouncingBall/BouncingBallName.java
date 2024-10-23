package BouncingBall;

import Doctrina.Canvas;
import Doctrina.Game;
import Doctrina.GameTime;

import java.awt.*;

public final class BouncingBallName extends Game {
    private int score;
    private Ball ball;


    @Override
    public void draw(Canvas canvas){
        ball.draw(canvas);

        canvas.drawString("score" + score, 10, 20,Color.WHITE);
        canvas.drawString(GameTime.getElapsedFormatTime(),10,40,Color.WHITE);
        canvas.drawString("FPS: " + GameTime.getCurrentFps(),10,60,Color.WHITE);
    }

    @Override
    protected void initialize() {
        ball = new Ball(25);

    }

    @Override
    public void update(){
        ball.update();
        if (ball.hasTouch()){
            score +=5;
        }
    }
}

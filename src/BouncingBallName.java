import java.awt.*;

public final class BouncingBallName extends Game{


    private int score;
    private Ball ball;



    BouncingBallName(){
        //jFrame.setUndecorated(true);
    }


    @Override
    public void draw(Canvas canvas){
        ball.draw(canvas);

        canvas.drawString("score" + score, 10, 20,Color.WHITE);
        canvas.drawString(GameTime.getElapsedFormatTime(),10,40,Color.WHITE);
        canvas.drawString("FPS: " + GameTime.getCurrentFps(),10,60,Color.WHITE);
    }

    @Override
    public void update(){
        ball.update();
        if (ball.hasTouch()){
            score +=5;
        }
    }

    @Override
    protected void initialize() {
        ball = new Ball(25);
    }
}

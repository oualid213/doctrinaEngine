import java.awt.*;

public final class BouncingBallName extends Game{


    private int score;
    private Ball ball;





    BouncingBallName(){
        //jFrame.setUndecorated(true);
    }






    @Override
    public void drawOnBuffer(Graphics2D bufferEngine){
        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("score" + score,10,32);
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

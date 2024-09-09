import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game  {



    private static final int SLEEP = 25;
    private boolean playing = true;

    private Long before;
    private int score;
    private Ball ball;


private RenderingEngine renderingEngine;




    Game(){
        renderingEngine = new RenderingEngine();
        //jFrame.setUndecorated(true);
        ball = new Ball(25);
    }




    public void start(){
        renderingEngine.start();
        before = System.currentTimeMillis();
        while(playing){




            update();
            drawOnBuffer(renderingEngine.buildBufferEngine());
            renderingEngine.drawBufferOnScreen();
            sleep();

            before = System.currentTimeMillis();
        }
    }

    private void sleep(){
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void drawOnBuffer(Graphics2D bufferEngine){
        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("score" + score,10,32);
    }


    private long getSleepTime() {
        Long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep<4){
            sleep = 4L;
        }

        return sleep;
    }


    private void update(){
        ball.update();
        if (ball.hasTouch()){
            score +=5;
        }
    }








}

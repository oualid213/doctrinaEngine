import java.awt.*;

public abstract class Game {
    private static final int SLEEP = 25;
    private boolean playing = true;
    private Long before;
    private RenderingEngine renderingEngine;

    public abstract void update();
    public abstract void drawOnBuffer(Graphics2D bufferEngine);


    Game(){
        renderingEngine = new RenderingEngine();
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
    private long getSleepTime() {
        Long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep<4){
            sleep = 4L;
        }

        return sleep;
    }



}

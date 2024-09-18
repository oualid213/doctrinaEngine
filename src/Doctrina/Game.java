package Doctrina;

import java.awt.event.KeyListener;

public abstract class Game {
    private boolean playing = true;
    private RenderingEngine renderingEngine;

    public abstract void update();
    public abstract void draw(Canvas canvas);
    protected abstract void initialize();

    public Game(){
        renderingEngine = new RenderingEngine();
    }

    public final void start(){
        initialize();
        run();
    }



    private void run() {
        renderingEngine.start();
        GameTime gameTime = new GameTime();
        while (playing) {
            update();
            draw(renderingEngine.buildCanvas());
            renderingEngine.drawBufferOnScreen();

            gameTime.synchronize();
        }
    }

    public void addKeyListener(KeyListener keyListener){
        renderingEngine.addKeyListener(keyListener);
    }
}

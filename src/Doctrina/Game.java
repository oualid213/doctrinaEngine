package Doctrina;

public abstract class Game {
    private boolean playing = true;
    private final RenderingEngine renderingEngine;
    private final GameTime gameTime = new GameTime();


    public abstract void update();
    public abstract void draw(Canvas canvas);
    protected abstract void initialize();

    public Game(){
        renderingEngine = RenderingEngine.getINSTANCE();
    }

    public final void start(){
        initialize();
        run();
    }
    public final void stop(){
        playing = false;
    }

    private void run() {
        renderingEngine.start();
        while (playing) {
            update();
            draw(renderingEngine.buildCanvas());
            renderingEngine.drawBufferOnScreen();

            gameTime.synchronize();
        }
    }

}

public abstract class Game {
    private boolean playing = true;
    private RenderingEngine renderingEngine;

    public abstract void update();
    public abstract void draw(Canvas canvas);
    protected abstract void initialize();

    Game(){
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

            gameTime.sleep();
        }
    }
}

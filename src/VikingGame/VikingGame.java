package VikingGame;

import Doctrina.Canvas;
import Doctrina.Game;


public class VikingGame extends Game {
    private Player player;
    private GamePad gamePad;
    private Word word;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        word = new Word();
        word.load();
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    public void draw(Canvas canvas) {
        word.draw(canvas);
        player.draw(canvas);
    }
}

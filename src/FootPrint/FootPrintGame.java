package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;

public class FootPrintGame extends Game {
    private GamePad gamePad;
    private Player player;

    @Override
    public void update() {
        if (gamePad.isQuitPressed()){
            stop();
        }
        player.update();

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.blue);
        player.draw(canvas);
    }

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);

    }
}

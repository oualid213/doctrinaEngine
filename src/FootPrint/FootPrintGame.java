package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootPrintGame extends Game {
    private GamePad gamePad;
    private Player player;
    private ArrayList<FootPrint> footPrints;

    @Override
    public void update() {
        if (gamePad.isQuitPressed()){
            stop();
        }
        player.update();

        if (gamePad.isMoving()){
            footPrints.add(player.layFootPrint());
        }

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.blue);

        for (FootPrint footPrint : footPrints){
            footPrint.draw(canvas);
        }

        player.draw(canvas);
    }

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        footPrints = new ArrayList<>();
    }
}

package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;
import java.util.ArrayList;

public class FootPrintGame extends Game {
    private GamePad gamePadOne;
    private GamePad gamePadTwo;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<FootPrint> footPrints;

    @Override
    public void update() {
        if (gamePadOne.isQuitPressed()){
            stop();
        }

        playerOne.update();
        playerTwo.update();

        if (gamePadOne.isMoving()){
            footPrints.add(playerOne.layFootPrint());
        }
        if (gamePadTwo.isMoving()){
            footPrints.add(playerTwo.layFootPrint());
        }

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.blue);
        for (FootPrint footPrint : footPrints){
            footPrint.draw(canvas);
        }


        playerOne.draw(canvas);
        playerTwo.draw(canvas);
    }

    @Override
    protected void initialize() {
        gamePadOne = new GamePad();

        gamePadTwo = new GamePad();
        gamePadTwo.useWASDKeys();

        playerOne = new Player(gamePadOne);
        playerTwo = new Player(gamePadTwo);

        footPrints = new ArrayList<>();
    }
}

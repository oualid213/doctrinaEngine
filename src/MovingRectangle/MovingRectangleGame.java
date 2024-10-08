package MovingRectangle;

import Doctrina.Game;
import Doctrina.Canvas;

import java.awt.*;


public class MovingRectangleGame extends Game{

        private GamePad gamePad;
        private Player player;
        private NPC npc;
    @Override
    public void update() {
        if(gamePad.isQuitPressed()){
            stop();
        }
        player.update();
        npc.update();

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(0,0,800,600, Color.blue);
        player.draw(canvas);
        npc.draw(canvas);

    }

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        npc = new NPC();
    }
}

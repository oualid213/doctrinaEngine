package MovingRectangle;

import Doctrina.Game;
import Doctrina.Canvas;

import java.awt.*;

public class MovingRectangleGame extends Game{

        private Player player;
        private NPC npc;
    @Override
    public void update() {
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
        player = new Player();
        npc = new NPC();

    }
}

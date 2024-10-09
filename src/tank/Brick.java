package tank;

import Doctrina.Canvas;
import Doctrina.StaticEntity;

import java.awt.*;

public class Brick extends StaticEntity {
    public Brick(int x, int y) {
        setDimension(14,14);
        teleport(x,y);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}

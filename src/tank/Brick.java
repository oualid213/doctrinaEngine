package tank;

import Doctrina.Canvas;
import Doctrina.CollidibaleRepository;
import Doctrina.StaticEntity;

import java.awt.*;

public class Brick extends StaticEntity {
    public Brick(int x, int y) {
        setDimension(14,14);
        teleport(x,y);
        CollidibaleRepository.getInstance().registerStaticEntity(this);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
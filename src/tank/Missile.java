package tank;
import Doctrina.Canvas;
import Doctrina.Direction;
import Doctrina.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {

    private  Direction direction;
    public Missile(Tank tank){
        direction = tank.getDirection();

        initialize(tank);
        setSpeed(5);

    }


    private void initialize(Tank tank){
        if (direction == Direction.RIGHT){
            setDimension(8,4);
            teleport(tank.getX() + tank.getWidth() + 1, tank.getY() + tank.getHeight()/2 - 1);
        }
        if (direction == Direction.LEFT){
            setDimension(8,4);
            teleport(tank.getX() - 9, tank.getY() + 15 - 2);
        }
        if (direction == Direction.DOWN){
            setDimension(8,4);
            teleport(tank.getX() + 15 -2, tank.getY() + 30 + 1);
        }
        if (direction == Direction.UP){
            setDimension(8,4);
            teleport(tank.getX() + 15 -2, tank.getY() + 15 -9);
        }
    }
    @Override
    public void update() {
        move(direction);

        if(x>800){
            direction = Direction.LEFT;
        }
        if(y>= 620){
            y = -20;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }
}

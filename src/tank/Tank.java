package tank;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {
    private int coolDown =0 ;

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30,30);
        setSpeed(3);
        teleport(300,300);
    }
    public Missile fire(){
        coolDown = 40;
        return new Missile(this);
    }
    public boolean canFire(){
        return coolDown ==0;
    }
    @Override
    public void update() {
        moveWidthController();

        coolDown--;
        if (coolDown < 0 ){
            coolDown = 0;
        }
    }

    @Override
    public void draw(Canvas canvas) {
    canvas.drawRectangle(this, Color.GREEN);
    int coolDownWidth = (coolDown * width)/40;
    canvas.drawRectangle(x,y -5, coolDownWidth, 2, Color.red);
    }


}

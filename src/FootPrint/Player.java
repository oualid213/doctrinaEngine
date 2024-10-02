package FootPrint;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.Game;
import Doctrina.MovableEntity;

import java.awt.*;

public class Player  extends ControllableEntity {

    public Player(GamePad gamePad){
        super(gamePad);
        teleport(200,200);
        setDimension(20,20);
        setSpeed(5);
    }
    @Override
    public void update(){moveWidthController();}
    @Override
    public void draw(Canvas canvas){canvas.drawRectangle(this, Color.white);}

    public FootPrint layFootPrint(){return new FootPrint(x,y);}
}

package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;
import Doctrina.MovableEntity;

import java.awt.*;

public class Player  extends MovableEntity {
    private GamePad gamePad;

    public Player(GamePad gamePad){
        this.gamePad = gamePad;
        teleport(200,200);
        setDimension(20,20);
        setSpeed(3);
    }

    public void update(){
       if (gamePad.isMoving()){
           move(gamePad.getDirection());
       }
    }

    public void draw(Canvas canvas){
        canvas.drawRectangle(this, Color.white);
    }

    public FootPrint layFootPrint(){
        return new FootPrint(x,y);
    }
}

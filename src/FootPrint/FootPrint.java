package FootPrint;

import Doctrina.Canvas;
import Doctrina.StaticEntity;

import java.awt.*;
import java.util.Random;

public class FootPrint extends StaticEntity {

    public FootPrint(int x, int y){
        teleport(x,y);
        setDimension(5,5);
    }
    @Override
    public void draw(Canvas canvas){
        Color color = new Color(getRandomValue(),getRandomValue(),getRandomValue());
        canvas.drawRectangle(x,y,width,height,color);
    }
    private int getRandomValue(){
        return new Random().nextInt(250);
    }

}

package Doctrina;

import java.awt.*;

public class Canvas {
    private Graphics2D graphics;



    Canvas(Graphics2D graphics){
        this.graphics = graphics;
    }

    public void drawString(String string, int x, int y , Paint paint ){
        graphics.setPaint(paint);
        graphics.drawString(string,x,y);
    }
    public void drawCircle( int x, int y ,int radius, Paint paint){
        graphics.setPaint(paint);
        graphics.fillOval(x,y,radius*2,radius*2);
    }
    public void drawRectangle( int x, int y ,int width,int height,Paint paint){
        graphics.setPaint(paint);
        graphics.fillOval(x,y,width,height);
    }



}

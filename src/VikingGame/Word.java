package VikingGame;

import java.awt.*;
import java.io.IOException;

import Doctrina.Canvas;

import javax.imageio.ImageIO;

public class Word {
    private static final String MAP_PATH = "Images/demo.png";

    private Image background;

    public void load(){
        try {
            background =  ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(MAP_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("yo my G");
        }

    }
    public void draw(Canvas canvas){
        canvas.drawImage(background,0,-64);

    }
}

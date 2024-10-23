package VikingGame;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.MovementController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends ControllableEntity {

    private static final String SPRITE_PATH ="Images/player.png";
    private BufferedImage image;
    private Image[] rightFrames;
    private Image[] leftFrames;
    private Image[] downFrames;
    private Image[] upFrames;

    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setSpeed(3);
        load();
    }
    private void load(){
        loadSpriteSheet();
        loadAnimationFrames();
    }
    private void loadSpriteSheet(){
        try {
            image =  ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("yo my G");
        }
    }
    private void loadAnimationFrames(){
        downFrames = new Image[3];
        downFrames[0] = image.getSubimage(0,128,width,height);
        downFrames[1] = image.getSubimage(32,128,width,height);
        downFrames[2] = image.getSubimage(32*2,128,width,height);

        leftFrames = new Image[3];
        leftFrames[0] = image.getSubimage(0,5*32,width,height);
        leftFrames[1] = image.getSubimage(32,5*32,width,height);
        leftFrames[2] = image.getSubimage(32*2,5*32,width,height);

        rightFrames = new Image[3];
        rightFrames[0] = image.getSubimage(0,6*32,width,height);
        rightFrames[1] = image.getSubimage(32,6*32,width,height);
        rightFrames[2] = image.getSubimage(32*2,6*32,width,height);

        upFrames = new Image[3];
        upFrames[0] = image.getSubimage(0,7*32,width,height);
        upFrames[1] = image.getSubimage(32,7*32,width,height);
        upFrames[2] = image.getSubimage(32*2,7*32,width,height);
    }
    @Override
    public void update() {
        super.update();
        moveWidthController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(downFrames[0],x,y);
    }
}

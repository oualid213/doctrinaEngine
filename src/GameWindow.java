import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameWindow extends JFrame {

    private JPanel jpanel;
    private static final int SLEEP = 25;
    private boolean playing = true;
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private Long before;
    private int score;
    private Ball ball;







    GameWindow(){
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Bouncing Balls");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setState(JFrame.NORMAL);

        jpanel = new JPanel();
        jpanel.setBackground(Color.blue);
        jpanel.setFocusable(true);
        jpanel.setDoubleBuffered(true);
        add(jpanel);
    }


    public void start(){
        setVisible(true);
        ball = new Ball(25);

        before = System.currentTimeMillis();
        while(playing){
            bufferedImage = new BufferedImage(800,600,
                    BufferedImage.TYPE_INT_RGB);
            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            renderingHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

            bufferEngine = bufferedImage.createGraphics();
            bufferEngine.setRenderingHints(renderingHints);

            update();
            drawOnBuffer();
            drawBufferOnScreen();


            Long sleep = SLEEP - (System.currentTimeMillis() - before);
            if (sleep<4){
                sleep = 4L;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            before = System.currentTimeMillis();
        }
    }

    private void update(){
        ball.update();
        if (ball.hasTouch()){
            score +=5;
        }
    }


    private void drawOnBuffer(){
        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("score" + score,10,32);
    }

    private void drawBufferOnScreen(){
        Graphics2D graphics = (Graphics2D) jpanel.getGraphics();
        graphics.drawImage(bufferedImage,0,0,jpanel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }


}

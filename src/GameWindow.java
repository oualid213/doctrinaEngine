import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameWindow extends JFrame {

    private JPanel jpanel;
    private static final int SLEEP = 25;
    private Random rnd = new Random();
    private boolean playing = true;
    private int radius = 25 ;
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private Long before;
    private int score;
    private int x = randomNumber(radius * 2, 800 - radius *  2);
    private int y = randomNumber(radius * 2, 600 - radius *  2);
    private int dx = randomNumber(0,1) == 0 ? 5 : -5;
    private int dy = randomNumber(0,1) == 0 ? 5 : -5;






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
    private int randomNumber(int min,int max){
        // il faut l utiliser
        return rnd.nextInt((max-min)+1)+min;
    }
    private void update(){
        x += dx;
        y += dy;
        if(y<= radius || y >= 600-radius){
            dy *= -1;
            score += 10;
        }
        if(x<= radius || x >= 800-radius){
            dx *= -1;
            score += 10;
        }
    }
    private void drawOnBuffer(){
        bufferEngine.setPaint(Color.red);
        bufferEngine.fillOval(x,y,radius*2,radius*2);


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

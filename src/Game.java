import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game  {


    private JFrame jFrame;
    private JPanel jpanel;
    private static final int SLEEP = 25;
    private boolean playing = true;
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private Long before;
    private int score;
    private Ball ball;







    Game(){
        initializeFrame();
        //jFrame.setUndecorated(true);
        initializePanel();
        ball = new Ball(25);
    }




    public void start(){
        jFrame.setVisible(true);

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
    private void initializePanel() {
        jpanel = new JPanel();
        jpanel.setBackground(Color.blue);
        jpanel.setFocusable(true);
        jpanel.setDoubleBuffered(true);
        jFrame.add(jpanel);
    }
    private void initializeFrame() {
        jFrame = new JFrame();
        jFrame.setSize(800,600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle("Bouncing Balls");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setState(JFrame.NORMAL);
    }




}

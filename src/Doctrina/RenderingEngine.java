package Doctrina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class RenderingEngine {
    private JFrame jFrame;
    private JPanel jpanel;
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private static RenderingEngine INSTANCE;


     private RenderingEngine(){
        initializeFrame();
        initializePanel();
    }

    public static RenderingEngine getINSTANCE(){
         if (INSTANCE == null){
             INSTANCE = new RenderingEngine();
         }
         return INSTANCE;
    }

    private void initializePanel() {
        jpanel = new JPanel();
        jpanel.setBackground(Color.blue);
        jpanel.setFocusable(true);
        jpanel.setDoubleBuffered(true);
        jFrame.add(jpanel);
    }

    public void start(){
        jFrame.setVisible(true);

    }

    public void stop(){
        jFrame.setVisible(false);
        jFrame.dispose();
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

    public void drawBufferOnScreen(){
        Graphics2D graphics = (Graphics2D) jpanel.getGraphics();
        graphics.drawImage(bufferedImage,0,0,jpanel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }


    public Canvas buildCanvas() {
        bufferedImage = new BufferedImage(800,600,
                BufferedImage.TYPE_INT_RGB);

        bufferEngine = bufferedImage.createGraphics();
        bufferEngine.setRenderingHints(buildRenderingHints());
        return new Canvas(bufferEngine);
    }
    private RenderingHints buildRenderingHints() {
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        return renderingHints;
    }

    public void addKeyListener(KeyListener keyListener){
        jpanel.addKeyListener(keyListener);
    }


}

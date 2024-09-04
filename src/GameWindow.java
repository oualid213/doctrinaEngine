import javax.swing.*;
import java.awt.*;
public class GameWindow extends JFrame {

    private JPanel jpanel;


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
    }

}

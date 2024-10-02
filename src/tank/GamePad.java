package tank;

import Doctrina.MovementController;

import javax.security.auth.kerberos.KeyTab;
import java.awt.event.KeyEvent;

public class GamePad extends MovementController {
    private int quitKey = KeyEvent.VK_Q;
    private int fireKey = KeyEvent.VK_SPACE;

    public GamePad() {
        findKey(quitKey);
        findKey(fireKey);
    }


    public boolean isQuitPressed(){
        return isKeyPressed(quitKey);
    }
    public boolean isFirePressed(){
        return isKeyPressed(fireKey);
    }
}

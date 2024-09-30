package Doctrina;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public abstract class Controller implements KeyListener {

    private final HashMap<Integer, Boolean> pressedKey;


    protected Controller() {
        pressedKey = new HashMap<>();
        RenderingEngine.getINSTANCE().addKeyListener(this);
    }
    protected void findKey(int keyCode){
        pressedKey.put(keyCode,false);
    }
    protected void unbindKey(int keyCode){
        pressedKey.remove(keyCode) ;
    }
    protected void clearKey(int keyCode){
        pressedKey.clear();
    }
    public boolean isKeyPressed(int keyCode){
        return pressedKey.containsKey(keyCode)
                && pressedKey.get(keyCode);

    }





    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(pressedKey.containsKey(keyCode)){
            pressedKey.put(keyCode, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(pressedKey.containsKey(keyCode)){
            pressedKey.put(keyCode, false);
        }

    }



}

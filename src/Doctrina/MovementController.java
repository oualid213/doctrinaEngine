package Doctrina;

import java.awt.event.KeyEvent;
import java.security.Key;

public class MovementController extends Controller{

    private int upKey = KeyEvent.VK_UP;
    private int downKey = KeyEvent.VK_DOWN;
    private int rightKey = KeyEvent.VK_RIGHT;
    private int leftKey = KeyEvent.VK_LEFT;

    public MovementController(){
        findKey(upKey);
        findKey(downKey);
        findKey(leftKey);
        findKey(rightKey);
    }
    public void useWASDKeys(){
        setUpKey(KeyEvent.VK_W);
        setDownKey(KeyEvent.VK_S);
        setLeftKey(KeyEvent.VK_A);
        setRightKey(KeyEvent.VK_D);
    }
    public Direction getDirection(){
        if (isLeftPressed()){
            return Direction.LEFT;
        }
        if (isRightPressed()){
            return Direction.RIGHT;
        }
        if (isDownPressed()){
            return Direction.DOWN;
        }
        if (isUpPressed()){
            return Direction.UP;
        }
        return null;
    }

    public boolean isLeftPressed(){
        return isKeyPressed(leftKey);
    }
    public boolean isRightPressed(){
        return isKeyPressed(rightKey);
    }public boolean isUpPressed(){
        return isKeyPressed(upKey);
    }public boolean isDownPressed(){
        return isKeyPressed(downKey);
    }


    public boolean isMoving(){
        return isdownPressed() || isLeftPressed() || isUpPressed() || isRightPressed();
    }

    private boolean isdownPressed() {
        return isKeyPressed(downKey);

    }


    public void setDownKey(int key){
        unbindKey(downKey);
        findKey(key);
        this.downKey = key;
    }
    public void setUpKey(int key){
        unbindKey(upKey);
        findKey(key);
        this.upKey = key;
    }
    public void setLeftKey(int key){
        unbindKey(leftKey);
        findKey(key);
        this.leftKey = key;
    }
    public void setRightKey(int key){
        unbindKey(rightKey);
        findKey(key);
        this.rightKey = key;
    }


}

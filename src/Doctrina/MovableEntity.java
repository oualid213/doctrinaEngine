package Doctrina;

import java.awt.*;

public abstract class MovableEntity extends StaticEntity {

    private int speed = 1 ;
    private Direction direction = Direction.UP;


    private int lastX = Integer.MIN_VALUE;

    private int lastY = Integer.MIN_VALUE;
    private Collision collision;
    private boolean moved;
    public void update(){
        moved = false;
    };
    public MovableEntity(){
        collision = new Collision(this);
    }
    public void move(){
        int allowedSpeed = collision.getAllowedSpeed();
        x += direction.calculateVelocityX(allowedSpeed);
        y += direction.calculateVelocityY(allowedSpeed);
        moved = (x != lastX) || (y != lastY);
        lastX = x;
        lastY = y;
    }
    public boolean hasMoved(){
        return moved;
    }

    public void move(Direction direction){
        this.direction = direction;
        move();
        // TODO: faire le mouvement
    }

    public void moveUP(){
        move(Direction.UP);
    }
    public void moveDown(){
        move(Direction.DOWN);
    }
    public void moveLeft(){
        move(Direction.LEFT);
    }
    public void moveRight(){
        move(Direction.RIGHT);
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getHitBox(){
        if (direction == Direction.UP){
            return getUpperHitBox();
        }
        if (direction == Direction.DOWN){
            return  getLowerHitBox();
        }
        if (direction == Direction.LEFT){
            return  getLeftHitBox();
        }
        if (direction == Direction.RIGHT){
            return getRightHitBox();
        }
        return getBound();
    }
    public boolean hitBoxIntersectWith(StaticEntity entity){
        if (entity == null){
            return false;
        }
        return getHitBox().intersects(entity.getBound());
    }
    public void drawHitBox(Canvas canvas){
        Rectangle rectangle = getHitBox();
        canvas.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height,Color.blue);
    }

    private Rectangle getUpperHitBox() {
        return new Rectangle(x, y - speed, width, speed);
    }
    private Rectangle getLowerHitBox() {
        return new Rectangle(x, y + height, width, speed);
    }

    private Rectangle getLeftHitBox() {
        return new Rectangle(x-speed, y, speed, height);
    }

    private Rectangle getRightHitBox() {
        return new Rectangle(x + width, y , speed, height);
    }


    public Direction getDirection() {
        return direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

package Doctrina;

public abstract class MovableEntity extends StaticEntity {

    private int speed = 1 ;
    private Direction direction = Direction.UP;

    public abstract void update();

    public void move(){
        x += direction.calculateVelocityX(speed);
        y += direction.calculateVelocityY(speed);
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

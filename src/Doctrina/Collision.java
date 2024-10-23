package Doctrina;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class Collision {
    private final MovableEntity entity;

    public Collision(MovableEntity entity) {
        this.entity = entity;
    }
    public int getAllowedSpeed() {
        return switch (entity.getDirection()){
            case LEFT -> getAllowedLeftSpeed();
            case RIGHT -> getAllowedRightSpeed();
            case DOWN -> getAllowedDownSpeed();
            case UP -> getAllowedUpSpeed();
        };

    }
    private int getAllowedUpSpeed(){
        return distanceCalculator(other -> entity.y - (other.y + other.height));
    }
    private int getAllowedDownSpeed(){
        return distanceCalculator(other -> other.y - (entity.y + entity.height));
    }
    private int getAllowedLeftSpeed(){
        return distanceCalculator(other -> entity.x - (other.x + other.height));
    }
    private int getAllowedRightSpeed(){
        return distanceCalculator(other -> other.x - (entity.x + entity.height));
    }
    private int distanceCalculator(DistanceCalculator calculator){

        Rectangle hitBox = entity.getHitBox();
        int allowedDistance = entity.getSpeed();

        for(StaticEntity other: CollidibaleRepository.getInstance()){
            if (hitBox.intersects(other.getBound())){
                allowedDistance = Math.min(allowedDistance,calculator.calculateWith(other));
            }
        }
        return allowedDistance;
    }
    public interface DistanceCalculator{
        int calculateWith(StaticEntity other);
    }
}

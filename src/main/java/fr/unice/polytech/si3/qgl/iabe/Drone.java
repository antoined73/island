package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.decisions.*;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.strategy.Compass;
import fr.unice.polytech.si3.qgl.iabe.strategy.Strategy;

/**
 * Created by Antoine on 12/3/2016.
 */
public class Drone {
    private Direction current_direction;
    private int xPosition;
    private int yPosition;

    public Drone(Direction direction) {
        xPosition = 0;
        this.current_direction = direction;
    }

    public void setYPosition(int yPosition){
        this.yPosition = yPosition;
    }

    public Decision echo(Direction direction) {
        return new Echo(direction);
    }

    public Decision scan() {
        return new Scan();
    }

    public Decision fly() {
        fly(current_direction);
        return new Fly();
    }

    public Decision turn(Direction direction) {
        turnDrone(current_direction,direction);
        current_direction = direction;
        return new Heading(direction);
    }

    private void fly(Direction current_direction) {
        switch(current_direction){
            case E: this.increaseX();break;
            case W: this.decreaseX();break;
            case N: this.decreaseY();break;
            case S: this.increaseY(); break;
            default: break;
        }
    }

    private void turnDrone(Direction before_direction, Direction after_direction) {
        fly(before_direction);
        fly(after_direction);
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public Direction getCurrentDirection(){ return current_direction;}

    private void decreaseY() {
        this.yPosition--;
    }

    private void increaseX() {
        this.xPosition++;
    }

    private void increaseY() {
        this.yPosition++;
    }

    private void decreaseX() {
        this.xPosition--;
    }

    public Decision turnLeft() {
        return turn(new Compass().getLeftOf(current_direction));
    }

    public Decision turnRight() {
        return turn(new Compass().getRightOf(current_direction));
    }

    public Decision echoForward() {
        return  echo(current_direction);
    }

    public Decision echoRight() {
        return echo(new Compass().getRightOf(current_direction));
    }

    public Decision echoLeft() {
        return echo(new Compass().getLeftOf(current_direction));
    }

    public Direction getLeft() {
        return new Compass().getLeftOf(current_direction);
    }

    public Direction getRight() {
        return new Compass().getRightOf(current_direction);
    }
}

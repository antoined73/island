package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.Direction;

import static fr.unice.polytech.si3.qgl.iabe.Direction.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 12/11/2016.
 */
public class Compass {

    private List<Direction> directions;

    public Compass() {
        Direction[] directionsArray = {W,N,E,S};
        this.directions = new ArrayList<>();
        for(Direction direction : directionsArray) {
            this.directions.add(direction);
        }
    }

    public Direction getRightOf(Direction initialDirection) {
        return getRightElementOf(directions.indexOf(initialDirection));
    }

    private Direction getRightElementOf(int i) {
        try{
            return directions.get(i+1);
        }catch(Exception e){
            return directions.get(0);
        }
    }

    public Direction getLeftOf(Direction initialDirection) {
        return getLeftElementOf(directions.indexOf(initialDirection));
    }

    private Direction getLeftElementOf(int i) {
        try{
            return directions.get(i-1);
        }catch(Exception e){
            return directions.get(directions.size()-1);
        }
    }

    public Direction getOppositeOf(Direction currentDirection) {
        return getRightOf(getRightOf(currentDirection));
    }
}

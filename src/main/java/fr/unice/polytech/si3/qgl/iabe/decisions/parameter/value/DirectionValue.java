package fr.unice.polytech.si3.qgl.iabe.decisions.parameter.value;

import fr.unice.polytech.si3.qgl.iabe.Direction;

/**
 * Created by Antoine on 12/11/2016.
 */
public class DirectionValue implements Value{

    private Direction direction;

    public DirectionValue(Direction direction) {
        this.direction = direction;
    }

    public String toString() {
        return direction.toString();
    }
}

package fr.unice.polytech.si3.qgl.iabe.decisions;

import fr.unice.polytech.si3.qgl.iabe.Direction;
import fr.unice.polytech.si3.qgl.iabe.decisions.parameter.DirectionParameter;

/**
 * Created by Olivier on 18/11/2016.
 */
public class Echo extends Decision{

    private Direction direction;

    public Echo(Direction direction) {
        super("echo",new DirectionParameter(direction));
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

}

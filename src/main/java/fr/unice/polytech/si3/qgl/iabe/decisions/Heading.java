package fr.unice.polytech.si3.qgl.iabe.decisions;

import fr.unice.polytech.si3.qgl.iabe.Direction;
import fr.unice.polytech.si3.qgl.iabe.decisions.parameter.DirectionParameter;

/**
 * Created by Olivier on 18/11/2016.
 */
public class Heading extends Decision{

    private Direction direction;

    public Heading(Direction direction) {
        super("heading",new DirectionParameter(direction));
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}

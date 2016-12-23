package fr.unice.polytech.si3.qgl.iabe.decisions.parameter;

import fr.unice.polytech.si3.qgl.iabe.Direction;
import fr.unice.polytech.si3.qgl.iabe.decisions.parameter.value.DirectionValue;

/**
 * Created by Antoine on 12/7/2016.
 */
public class DirectionParameter extends Parameter {

    public DirectionParameter(Direction direction) {
        super("direction", new DirectionValue(direction));
    }
}

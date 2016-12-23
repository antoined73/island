package fr.unice.polytech.si3.qgl.iabe.result.factories;

import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

/**
 * Created by Olivier on 11/12/2016.
 */
public abstract class Factory {

    protected ResultParser parser;

    public Factory(ResultParser parser) {
        this.parser = parser;
    }

    public abstract Result getResult();
}

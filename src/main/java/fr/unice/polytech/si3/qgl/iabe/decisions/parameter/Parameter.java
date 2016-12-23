package fr.unice.polytech.si3.qgl.iabe.decisions.parameter;

import fr.unice.polytech.si3.qgl.iabe.decisions.parameter.value.Value;

/**
 * Created by Antoine on 12/7/2016.
 */
public class Parameter {
    private String name;
    private Value value;

    public Parameter(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public String getValue(){
        return this.value.toString();
    }
}


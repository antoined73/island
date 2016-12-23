package fr.unice.polytech.si3.qgl.iabe.decisions;

import fr.unice.polytech.si3.qgl.iabe.tools.JSONBuilder;
import fr.unice.polytech.si3.qgl.iabe.decisions.parameter.Parameter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Antoine on 12/3/2016.
 */
public class Decision {

    private String name;
    private Optional<List<Parameter>> parameters = Optional.empty();

    public Decision(String name,Parameter... parameters) {
        this.name = name;
        List<Parameter> list = Arrays.asList(parameters);
        if(!list.isEmpty()) {
            this.parameters = Optional.ofNullable(list);
        }
    }

    public String toString(){
        return JSONBuilder.getJSONObject(this).toString();
    }

    public String getName() {
        return name;
    }

    public Optional<List<Parameter>> getParameters() {
        return parameters;
    }
}

package fr.unice.polytech.si3.qgl.iabe.tools;

import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.decisions.parameter.Parameter;
import org.json.JSONObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.print.attribute.Size2DSyntax;
import java.util.List;
import java.util.Optional;

/**
 * Created by Antoine on 12/7/2016.
 */
public class JSONBuilder {

    public static JSONObject getJSONObject(Decision decision) {
        return createJSON(decision);
    }

    private static JSONObject createJSON(Decision decision) {
        JSONObject answer = new JSONObject();
        addAction(answer,decision);
        addParameters(answer,decision);
        return answer;
    }

    private static void addParameters(JSONObject answer, Decision decision) {
        Optional<List<Parameter>> parameters = decision.getParameters();
        if(parameters.isPresent()) {
            JSONObject parametersJSONObject = new JSONObject();
            for (Parameter parameter : parameters.get()) {
                parametersJSONObject.put(parameter.getName(), parameter.getValue());
            }
            answer.put("parameters", parametersJSONObject);
        }
    }

    private static void addAction(JSONObject answer, Decision decision) {
        String name = decision.getName();
        answer.put("action",name);
    }

}

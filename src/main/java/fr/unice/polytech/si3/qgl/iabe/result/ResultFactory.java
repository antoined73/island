package fr.unice.polytech.si3.qgl.iabe.result;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.result.factories.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Olivier on 08/12/2016.
 * This class extract some data from a JSON
 *
 */
public class ResultFactory {

    private Map<String,Factory> hashmap;
    private Decision previousDecision;

    public ResultFactory(ResultParser parser, Decision previousDecision) {
        this.previousDecision = previousDecision;
        this.hashmap = new HashMap<>();
        hashmap.put("echo",new EchoFactory(parser));
        hashmap.put("scan",new ScanFactory(parser));
        hashmap.put("fly",new FlyFactory(parser));
        hashmap.put("stop",new StopFactory(parser));
    }

    public Result getResult() {
        String previousDecisionName = previousDecision.getName();

        if(hashmap.containsKey(previousDecisionName)){
            Factory factory = hashmap.get(previousDecisionName);
            return factory.getResult();
        }else{
            throw new NoSuchElementException("Hashmap hasn't this decision name:"+previousDecisionName);
        }

    }
}

package fr.unice.polytech.si3.qgl.iabe.result.factories;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

/**
 * Created by Olivier on 11/12/2016.
 */
public class EchoFactory extends Factory {


    public EchoFactory(ResultParser parser) {
        super(parser);
    }

    public Result getResult(){
        return new EchoResult(parser);
    }

}

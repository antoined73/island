package fr.unice.polytech.si3.qgl.iabe.result.factories;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.result.factories.Factory;

/**
 * Created by Antoine on 12/24/2016.
 */
public class StopFactory extends Factory {
    public StopFactory(ResultParser parser) {
        super(parser);
    }

    public Result getResult(){
        return new Result(parser);
    }
}

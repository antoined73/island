package fr.unice.polytech.si3.qgl.iabe.result.factories;

import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

/**
 * Created by Antoine on 12/11/2016.
 */
public class FlyFactory extends Factory {
    public FlyFactory(ResultParser parser) {
        super(parser);
    }
    public Result getResult(){
        return new Result(parser);
    }

}

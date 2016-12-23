package fr.unice.polytech.si3.qgl.iabe.result.factories;

import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.result.ScanResult;

/**
 * Created by Olivier on 11/12/2016.
 */
public class ScanFactory extends Factory {

    public ScanFactory(ResultParser parser) {
        super(parser);
    }

    public Result getResult() {
        return new ScanResult(parser);
    }

}

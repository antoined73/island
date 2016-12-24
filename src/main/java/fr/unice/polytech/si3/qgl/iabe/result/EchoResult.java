package fr.unice.polytech.si3.qgl.iabe.result;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;

/**
 * Created by Antoine on 12/3/2016.
 */
public class EchoResult extends Result{
    private int range;
    private String found;

    public EchoResult(ResultParser parser) {
        super(parser);
        this.range = parser.getRange();
        this.found = parser.getFound();
    }

    public int getRange() {
        return range;
    }

    public String getFound() {
        return found;
    }

    public boolean foundedGround() {
        return this.found.equals("GROUND");
    }
}

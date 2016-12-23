package fr.unice.polytech.si3.qgl.iabe.result;

import fr.unice.polytech.si3.qgl.iabe.parser.Parser;
import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;

/**
 * Created by Antoine on 12/3/2016.
 */
public class Result {
    private int cost;
    private String status;

    public Result(ResultParser parser) {
        this.cost = parser.getCost();
        this.status = parser.getStatus();
    }

    public Result(int cost, String status) {
        this.cost = cost;
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }
}

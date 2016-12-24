package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

import java.util.List;

/**
 * Created by Antoine on 12/3/2016.
 */
public class FindSizeOfMapStrategy extends Strategy {
    private Drone drone;
    private Bot bot;
    private Map map;

    public FindSizeOfMapStrategy(Bot bot) {
        super(bot);
        this.bot = bot;
        this.map = bot.getMap();
        this.drone = map.getDrone();
    }

    @Override
    public void getDecisions(List<Decision> listOfDecision) {
        //nothing
    }

    @Override
    public void finishStrategy() {
        setNextStrategy(new FindIsland(bot));
        isFinished = true;
    }

    @Override
    public void initialize(List<Decision> listOfDecision) {
        listOfDecision.add(drone.echoRight());
        listOfDecision.add(drone.echoLeft());
        listOfDecision.add(drone.echoForward());
        listOfDecision.add(drone.fly());
        finishStrategy();
    }
}

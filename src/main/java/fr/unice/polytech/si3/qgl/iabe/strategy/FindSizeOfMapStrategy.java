package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

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
        initialize();
    }

    @Override
    public void acknowledgeResults(Result result) {

    }

    private void initialize() {
        Direction initialDirection = drone.getCurrentDirection();
        Compass compass = new Compass();
        Direction direction1 = compass.getRightOf(initialDirection);
        Direction direction2 = compass.getLeftOf(initialDirection);
        addDecision(drone.echo(direction1));
        addDecision(drone.echo(direction2));
        addDecision(drone.fly());
    }

    //@Override
    public void getDecision() {
        finishStrategy();
       /* if (previousDecisionWasEcho()) {
            EchoResult echoresult = (EchoResult) result;
            if (!echoresult.foundedGround()) {
                int rangeFounded = echoresult.getRange();
                map.addWidth(rangeFounded);
                if(previousDecisionWasEchoNorth()){
                    drone.setYPosition(echoresult.getRange());
                }
            }
        }
        if(previousDecisionWasFly()){
            finishStrategy();
        }*/
    }

    @Override
    public void finishStrategy() {
        setNextStrategy(new FindIsland(bot));
    }
}

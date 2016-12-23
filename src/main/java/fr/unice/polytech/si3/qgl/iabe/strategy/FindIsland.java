package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

import static fr.unice.polytech.si3.qgl.iabe.Direction.*;

/**
 * Created by Antoine on 12/3/2016.
 */
public class FindIsland extends Strategy {

    private boolean finished = false;

    public FindIsland(Bot bot) {
        super(bot);
        initialize();
    }

    private void initialize() {
        addDecision(drone.echo(E));
        addDecision(drone.echo(N));
        addDecision(drone.echo(S));
    }

    @Override
    public void acknowledgeResults(Result result) {
        /*if(!finished) {

            if (previousDecisionWasEcho()) {
                EchoResult echoresult = (EchoResult) result;

                if (echoresult.foundedGround()) {
                    finishStrategy();
                } else {
                    flyAndEchoUpAndDown();
                }
            }
        }*/
    }

    @Override
    public void finishStrategy() {
        removeAllDecision();
        setNextStrategy(new MapIslandStrategy(bot));
        finished = true;
        isFinished = true;
    }

    private void flyAndEchoUpAndDown() {
        addDecision(drone.fly());
        addDecision(drone.echo(N));
        addDecision(drone.echo(S));
    }
}
package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;

import java.util.List;

import static fr.unice.polytech.si3.qgl.iabe.Direction.*;

/**
 * Created by Antoine on 12/3/2016.
 */
public class FindIsland extends Strategy {

    private boolean finished = false;

    public FindIsland(Bot bot) {
        super(bot);
    }

    @Override
    public void getDecisions(List<Decision> listOfDecision) {
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
        boolean groundFoundedOnLeftOfDrone = map.foundGround(drone.getLeft(),drone.getX(),drone.getY());
        if(groundFoundedOnLeftOfDrone){
            listOfDecision.add(drone.turnLeft());
            finishStrategy();
        }
        boolean groundFoundedOnRightOfDrone = map.foundGround(drone.getRight(),drone.getX(),drone.getY());
        if(groundFoundedOnRightOfDrone){
            listOfDecision.add(drone.turnRight());
            finishStrategy();
        }

        boolean mapNotDiscoveredOnRightOfDrone= !map.isDiscovered(drone.getRight(), drone.getX(), drone.getY());
        if(mapNotDiscoveredOnRightOfDrone){
            listOfDecision.add(drone.echoRight());
        }

        boolean mapNotDiscoveredOnLeftOfDrone= !map.isDiscovered(drone.getLeft(), drone.getX(), drone.getY());
        if(mapNotDiscoveredOnLeftOfDrone){
            listOfDecision.add(drone.echoLeft());
        }

        if(!mapNotDiscoveredOnLeftOfDrone && !mapNotDiscoveredOnRightOfDrone){
            listOfDecision.add(drone.fly());
        }
    }

    @Override
    public void finishStrategy() {
        setNextStrategy(new MapIslandStrategy(bot));
        isFinished = true;
    }

    @Override
    public void initialize(List<Decision> listOfDecision) {
        /*listOfDecision.add(drone.echoLeft());
        listOfDecision.add(drone.echoRight());*/
    }
}
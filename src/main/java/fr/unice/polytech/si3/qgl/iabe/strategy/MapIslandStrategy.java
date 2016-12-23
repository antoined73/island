package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.result.ScanResult;

import static fr.unice.polytech.si3.qgl.iabe.Direction.N;
import static fr.unice.polytech.si3.qgl.iabe.Direction.S;

/**
 * Created by Antoine on 12/3/2016.
 */
public class MapIslandStrategy extends Strategy {
    private final Map map;
    private Drone drone;
    private Bot bot;
    private boolean finished = false;
    private boolean didOnePass = false;

    public MapIslandStrategy(Bot bot) {
        super(bot);
        this.bot = bot;
        this.map = bot.getMap();
        this.drone = map.getDrone();
        initialize();
    }

    private void initialize() {

        Echo echo = ((Echo)bot.getPreviousDecision());
        Direction previousEchoHeading = echo.getDirection();
        addDecision(drone.turn(previousEchoHeading));
        addDecision(drone.echo(previousEchoHeading));
    }

    @Override
    public void acknowledgeResults(Result result) {
        /*if(!finished) {
            if (previousDecisionWasEcho()) {
                EchoResult echoresult = (EchoResult) result;

                if (echoresult.foundedGround()) {
                    Echo echo = ((Echo)bot.getPreviousDecision());
                    Direction previousEchoHeading = echo.getDirection();
                    int range = echoresult.getRange();
                    for (int i = 0; i < range; i++) {
                        addDecision(drone.fly());
                    }
                    if(previousEchoHeading.equals(Direction.S)) { // if going south
                        scanNorthToSouth();
                    }else if(previousEchoHeading.equals(Direction.N)){ // if going north
                        scanSouthToNorth();
                    }
                }else{
                    //finished = true;
                    if(!didOnePass) {
                        didOnePass = true;
                        int y = drone.getY();
                        for(int i = y; i>1;i--) {
                            addDecision(drone.fly());
                        }
                        addDecision(drone.heading(Direction.W));
                        addDecision(drone.fly());
                        addDecision(drone.heading(Direction.S));
                        addDecision(drone.echoSouth());
                    }else{
                        isFinished = true;
                    }
                }
            }else if (previousDecisionWasScan()) {
                journal.setTrace((ScanResult)result);
            }
        }*/
    }

    @Override
    public void finishStrategy(){
        isFinished = true;
    }

    private void scanSouthToNorth() {
        int y = drone.getY();
        for(int i = y; i>1;i--) {
            addDecision(drone.scan());
            addDecision(drone.fly());
        }
        if(didOnePass){
            addDecision(drone.turn(Direction.W));
        }else {
            addDecision(drone.turn(Direction.E));
        }
        addDecision(drone.turn(S));
        addDecision(drone.echo(S));
    }

    private void scanNorthToSouth() {
        int y = drone.getY();
        int yMax = map.getSizeWidth();
        for(int i = y; i< yMax-1;i++) {
            addDecision(drone.scan());
            addDecision(drone.fly());
        }
        if(didOnePass){
            addDecision(drone.turn(Direction.W));
        }else {
            addDecision(drone.turn(Direction.E));
        }
        addDecision(drone.turn(N));
        addDecision(drone.echo(N));
    }
}

package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.parser.Parser;
import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.EchoResult;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.result.ResultFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Antoine on 12/3/2016.
 */
public abstract class Strategy {

    protected final Bot bot;
    protected final Map map;
    protected Drone drone;
    protected Journal journal;
    protected boolean isFinished = false;
    protected Optional<Strategy> nextStrategyToDo= Optional.empty();
    private List<Decision> listOfDecision = new ArrayList<Decision>();

    public Strategy(Bot bot) {
        this.bot = bot;
        this.map = bot.getMap();
        this.drone = map.getDrone();
        this.journal = bot.getJournal();
    }

    public Optional<Decision> getNextDecision(){
        Optional<Decision> decision = Optional.ofNullable(getFirstDecisionFromList());
        bot.setPreviousDecision(decision);
        return decision;
    }

    private Decision getFirstDecisionFromList() {
        Decision decision;
        try {
            decision = listOfDecision.get(0);
            listOfDecision.remove(0);
        }catch(IndexOutOfBoundsException e){
            decision = null;
        }
        return decision;
    }

    public boolean hasNextStrategy() {
        return this.nextStrategyToDo.isPresent();
    }

    protected void setNextStrategy(Strategy strategy){
        this.nextStrategyToDo = Optional.of(strategy);
    }

    public Strategy getNextStrategy() {
        return this.nextStrategyToDo.get();
    }

    public boolean isFinished() {
        return isFinished;
    }

//    protected boolean previousDecisionWasEcho() {
//        if(bot.getPreviousDecision().isPresent()) {
//            return bot.getPreviousDecision().get().getName().equals("echo");
//        }
//        return false;
//    }
//
//    protected boolean previousDecisionWasEchoNorth() {
//        if(bot.getPreviousDecision().isPresent()) {
//            Echo echo = ((Echo)bot.getPreviousDecision().get());
//            Direction previousEchoHeading = echo.getDirection();
//            return echo.getName().equals("echo")&&previousEchoHeading.equals(Direction.N);
//        }
//        return false;
//    }
//
//    protected boolean previousDecisionWasFly() {
//        if(bot.getPreviousDecision().isPresent()) {
//            return bot.getPreviousDecision().get().getName().equals("fly");
//        }
//        return false;
//    }
//
//    protected boolean previousDecisionWasScan() {
//        if(bot.getPreviousDecision().isPresent()) {
//            return bot.getPreviousDecision().get().getName().equals("scan");
//        }
//        return false;
//    }

    protected void removeAllDecision() {
        this.listOfDecision.clear();
    }

    public void addDecision(Decision decision) {
        this.listOfDecision.add(decision);
    }

//    protected Result generateResultFromParser(ResultParser parser) {
//        ResultFactory factory = new ResultFactory(parser,bot.getPreviousDecision().get());
//        return factory.getResult();
//    }

    public abstract void acknowledgeResults(Result result);

    public abstract void finishStrategy();

}

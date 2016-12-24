package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.*;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;

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
    private Optional<Strategy> nextStrategyToDo;

    public Strategy(Bot bot) {
        this.bot = bot;
        this.map = bot.getMap();
        this.drone = map.getDrone();
        this.journal = bot.getJournal();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public abstract void getDecisions(List<Decision> listOfDecision);

    public abstract void finishStrategy();

    public boolean hasNextStrategy() {
        return this.nextStrategyToDo.isPresent();
    }

    protected void setNextStrategy(Strategy strategy){
        this.nextStrategyToDo = Optional.of(strategy);
    }

    public Strategy getNextStrategy() {
        return this.nextStrategyToDo.get();
    }

    public abstract void initialize(List<Decision> listOfDecision);
}

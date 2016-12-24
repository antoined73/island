package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.Resources.ContextParser;
import fr.unice.polytech.si3.qgl.iabe.Resources.Resources;
import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.decisions.Stop;
import fr.unice.polytech.si3.qgl.iabe.map.Map;
import fr.unice.polytech.si3.qgl.iabe.observer.Observable;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.strategy.FindSizeOfMapStrategy;
import fr.unice.polytech.si3.qgl.iabe.strategy.Strategy;
import fr.unice.polytech.si3.qgl.iabe.result.ResultFactory;

import java.util.Optional;

/**
 * Created by Antoine on 12/3/2016.
 */
public class Bot extends Observable{

    private Strategy currentStrategy;
    protected Optional<Decision> previousDecision = Optional.empty();

    private Map map;
    private Journal journal;
    private Resources resources;
    private Driver driver;


    public Bot(ContextParser parser) {
        this.map = new Map(this, new Drone(Direction.valueOf(parser.getHeading())));
        this.journal = new Journal();
        setCurrentStrategy(new FindSizeOfMapStrategy(this));
        this.driver = new Driver(currentStrategy);
    }

    /**
     * Ask to the current strategy the next decision.
     * If there isn't more, the bot switch current strategy and take the first decision of it.
     * If there isn't anymore strategy, the bot stops.
     * @return the next decision.
     */
    public Decision takeDecision(){
        Optional<Decision> decision;
        decision = driver.getNextDecision();
        //security in order to NOT crash
        if(decision.isPresent()){
            setPreviousDecision(decision);
            return decision.get();
        }else{
            return stopTheBot();
        }
    }

    /**
     * Stop the bot returning a stop decision.
     * @return stop decision.
     */
    private Decision stopTheBot() {
        previousDecision = Optional.of(new Stop());
        return previousDecision.get();
    }

    /**
     * Switch of current strategy taking the next.
     */
    public void getNextStrategy() {
        this.currentStrategy = currentStrategy.getNextStrategy();
    }

    /**
     * Setter of current strategy.
     * @param strategy to put.
     */
    public void setCurrentStrategy(Strategy strategy) {
        this.currentStrategy = strategy;
    }

    /**
     * Get the result and send it to the rest of the system.
     * @param parser
     */
    public void acknowledgeResults(ResultParser parser){
        setState(parser);
        Result result = new ResultFactory(parser,previousDecision.get()).getResult();
        //this.currentStrategy.acknowledgeResults(result);
    }


    //GETTERS
    public Map getMap() {
        return map;
    }

//    public Optional<Decision> getPreviousDecision() {
//        return previousDecision.get();
//    }

    public void setPreviousDecision(Optional<Decision> previousDecision) {
        this.previousDecision = previousDecision;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setState(ResultParser result){
        setPreviousDecision(previousDecision.get());
        setResultParser(result);
        notifyAllObservers();
    }
}

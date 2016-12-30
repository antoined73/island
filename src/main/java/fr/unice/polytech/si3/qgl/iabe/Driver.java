package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Antoine on 12/24/2016.
 */
public class Driver {

    private Strategy currentStrategy;
    private List<Decision> listOfDecision;

    public Driver(Strategy currentStrategy) {
        this.currentStrategy = currentStrategy;
        this.listOfDecision = new ArrayList<Decision>();
        currentStrategy.initialize(listOfDecision);
    }

    public Optional<Decision> getNextDecision(){

        Optional<Decision> decision = getFirstDecisionFromList();
        if(decision.isPresent()) return decision;
        else{
            if(currentStrategy.isFinished()){
                if(currentStrategy.hasNextStrategy()) {
                    currentStrategy = currentStrategy.getNextStrategy();
                    currentStrategy.initialize(listOfDecision);
                    return getNextDecision();
                    //decision = Optional.ofNullable(currentStrategy.getDecision());
                }else{ // no more strategy & decisions, stop the bot
                    return Optional.empty();
                }
            }else{
                currentStrategy.getDecisions(listOfDecision);
                return getNextDecision();
            }
        }
        //return decision;
    }

    /**
     * Take the first decision form list. If there isn't, this method returns an empty optional.
     * @return an optional first decision from list
     */
    private Optional<Decision> getFirstDecisionFromList() {
        Optional<Decision> decision = Optional.empty();
        if(!listOfDecision.isEmpty()){
            decision = Optional.of(listOfDecision.get(0));
            listOfDecision.remove(0);
        }
        return decision;
    }

    protected void removeAllDecision() {
        this.listOfDecision.clear();
    }

}

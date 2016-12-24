package fr.unice.polytech.si3.qgl.iabe.observer;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 12/4/2016.
 */
public class Observable {

    private ResultParser resultParser;
    private Decision previousDecision;
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * Notify all observers that observable has changed.
     */
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Add an observer to the observable.
     * @param observer the observer to add.
     */
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * Getter of result.
     * @return the result.
     */
    public ResultParser getResultParser(){
        return this.resultParser;
    }

    /**
     * Getter of previousDecision
     * @return the previous decision
     */
    public Decision getPreviousDecision() {
        return previousDecision;
    }

    public void setResultParser(ResultParser resultParser) {
        this.resultParser = resultParser;
    }

    public void setPreviousDecision(Decision previousDecision) {
        this.previousDecision = previousDecision;
    }



}

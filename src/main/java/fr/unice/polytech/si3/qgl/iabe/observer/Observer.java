package fr.unice.polytech.si3.qgl.iabe.observer;

import fr.unice.polytech.si3.qgl.iabe.Bot;

/**
 * Created by Antoine on 12/4/2016.
 */
public abstract class Observer {
    protected Observable subject;

    public Observer(Bot bot) {
        this.subject = bot;
    }

    public abstract void update();
}
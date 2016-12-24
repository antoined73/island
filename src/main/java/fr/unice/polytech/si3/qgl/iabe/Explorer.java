package fr.unice.polytech.si3.qgl.iabe;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.si3.qgl.iabe.Resources.ContextParser;
import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;

public class Explorer implements IExplorerRaid {

    private Bot bot;

    @Override
    public void initialize(String stringContext) {
        ContextParser parser = new ContextParser(stringContext);
        this.bot = new Bot(parser);
    }

    @Override
    public String takeDecision() {
        Decision decision = this.bot.takeDecision();
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String stringResults) {
        ResultParser parser = new ResultParser(stringResults);
        this.bot.acknowledgeResults(parser);
    }

    @Override
    public String deliverFinalReport() {
        return bot.getJournal().buildReport();
    }
}

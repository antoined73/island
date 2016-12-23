package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.strategy.FindIsland;
import fr.unice.polytech.si3.qgl.iabe.strategy.Strategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 12/3/2016.
 */
public class ExplorerTest {

    private Explorer explorer;

    @Before
    public void setUp() throws Exception {
        explorer = new Explorer();
        explorer.initialize("{ \"men\": 12, \"budget\": 10000,\n" +
                "  \"contracts\": [\n" +
                "    { \"amount\": 600, \"resource\": \"WOOD\" },\n" +
                "    { \"amount\": 200, \"resource\": \"GLASS\" }\n" +
                "  ],\n" +
                "  \"heading\": \"W\"\n" +
                "}");
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void takeDecisionMayNotBeNullTest() throws Exception {
        assertNotNull(explorer.takeDecision());
    }

/*    @Test
    public void acknowledgeResults() throws Exception {

        explorer.acknowledgeResults("{ \"cost\": 4, \"extras\": {}, \"status\": \"OK\" }");
    }*/

    @Test
    public void deliverFinalReportMayNotBeNullTest() throws Exception {
        assertNotNull(explorer.deliverFinalReport());
    }

   /* @Test
    public void foundGround() throws Exception {
        Strategy s = new FindIsland(new Bot());
        s.addDecision(new Echo("E"));
        System.out.println(s.getNextDecision().get().toString());
        s.acknowledgeResults(new Parser("{ \"cost\": 4, \"extras\": { \"found\": \"GROUND\",\"range\": \"5\" }, \"status\": \"OK\" }"));
        assertNotEquals(s.getNextDecision().get().getName(),"echo");
    }

    @Test
    public void enchainerStrats() throws Exception {
        Strategy s = new FindIsland(new Bot());
        s.addDecision(new Echo("E"));
        System.out.println(s.getNextDecision().get().toString());
        s.acknowledgeResults(new Parser("{ \"cost\": 4, \"extras\": { \"found\": \"GROUND\",\"range\": \"5\" }, \"status\": \"OK\" }"));
        System.out.println(s.getNextDecision().get().toString());
        assertNotNull(s.getNextStrategy());
    }*/

 /*   @Test
    public void tesers() throws Exception {
        Bot b = new Bot();
        s.addDecision(new Echo("E"));
        System.out.println(s.getNextDecision().get().toString());
        s.acknowledgeResults(new Parser("{ \"cost\": 4, \"extras\": { \"found\": \"GROUND\",\"range\": \"5\" }, \"status\": \"OK\" }"));
        System.out.println(s.getNextDecision().get().toString());
        System.out.println(s.getNextDecision().get().toString());
        assertNotNull(s.getNextStrategy());
    }*/
}
package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.Resources.ContextParser;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.decisions.Stop;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 12/3/2016.
 */
public class BotTest{

    private Bot bot;
    @Before
    public void setUp() throws Exception {
        ContextParser parser = new ContextParser("{ \"men\": 12, \"budget\": 10000,\n" +
                "  \"contracts\": [\n" +
                "    { \"amount\": 600, \"resource\": \"WOOD\" },\n" +
                "    { \"amount\": 200, \"resource\": \"GLASS\" }\n" +
                "  ],\n" +
                "  \"heading\": \"W\"\n" +
                "}");
        bot = new Bot(parser);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void takeDecisionTest(){
        //there is at least one decision that bot take, Stop decision.
        Decision d = bot.takeDecision();
        assertNotNull(d);
    }

    @Ignore
    public void getAStopTest(){
        //Verify that the program ends with stop anytime
        Decision d;
        do{
            d = bot.takeDecision();
            System.out.println(d.getName());
        }while(!d.getClass().getSimpleName().equals("Stop"));
        assertEquals(d.getClass(),new Stop().getClass());
    }

}
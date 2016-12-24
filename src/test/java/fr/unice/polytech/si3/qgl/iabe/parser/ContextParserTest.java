package fr.unice.polytech.si3.qgl.iabe.parser;

import fr.unice.polytech.si3.qgl.iabe.Resources.ContextParser;
import fr.unice.polytech.si3.qgl.iabe.Resources.Crafted;
import fr.unice.polytech.si3.qgl.iabe.Resources.Primary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Olivier on 22/12/2016.
 */
public class ContextParserTest {

    ContextParser fullContext;

    @Before
    public void setUp() {

        fullContext = new ContextParser("{ \n" +
                "  \"men\": 12,\n" +
                "  \"budget\": 10000,\n" +
                "  \"contracts\": [\n" +
                "    { \"amount\": 600, \"resource\": \"WOOD\" },\n" +
                "    { \"amount\": 200, \"resource\": \"FLOWER\" },\n" +
                "    { \"amount\": 500, \"resource\": \"QUARTZ\" },\n" +
                "    { \"amount\": 100, \"resource\": \"ORE\" },\n" +
                "    { \"amount\": 900, \"resource\": \"GLASS\" },\n" +
                "    { \"amount\": 400, \"resource\": \"INGOT\" },\n" +
                "    { \"amount\": 1000, \"resource\": \"RUM\" }\n" +
                "  ],\n" +
                "  \"heading\": \"W\"\n" +
                "}");

    }

    @Test
    public void getHeading() throws Exception {

        assertNotNull(fullContext.getHeading());
        assertEquals("W", fullContext.getHeading());

    }

    @Test
    public void getPrimaryContracts() throws Exception {

        assertNotNull(fullContext.getPrimaryContracts());

        assertFalse(fullContext.getPrimaryContracts().isEmpty());

        for (int i = 0; i < fullContext.getPrimaryContracts().size(); i++) {

           assertEquals(Primary.class, fullContext.getPrimaryContracts().get(i).getClass());

        }

        ContextParser emptyPrimary = new ContextParser("{ \n" +
                "  \"men\": 12,\n" +
                "  \"budget\": 10000,\n" +
                "  \"contracts\": [\n" +
                "    { \"amount\": 900, \"resource\": \"GLASS\" },\n" +
                "    { \"amount\": 400, \"resource\": \"INGOT\" },\n" +
                "    { \"amount\": 1000, \"resource\": \"RUM\" }\n" +
                "  ],\n" +
                "  \"heading\": \"W\"\n" +
                "}");

        assertNotNull(emptyPrimary.getPrimaryContracts());

        assertTrue(emptyPrimary.getPrimaryContracts().isEmpty());



    }

    @Test
    public void getCraftContracts() throws Exception {

        assertNotNull(fullContext.getCraftContracts());

        assertFalse(fullContext.getCraftContracts().isEmpty());

        for (int i = 0; i < fullContext.getCraftContracts().size(); i++) {

            assertEquals(Crafted.class, fullContext.getCraftContracts().get(i).getClass());

        }

        ContextParser emptyCrafted = new ContextParser("{ \n" +
                "  \"men\": 12,\n" +
                "  \"budget\": 10000,\n" +
                "  \"contracts\": [\n" +
                "    { \"amount\": 600, \"resource\": \"WOOD\" },\n" +
                "    { \"amount\": 200, \"resource\": \"FLOWER\" },\n" +
                "    { \"amount\": 500, \"resource\": \"QUARTZ\" },\n" +
                "    { \"amount\": 100, \"resource\": \"ORE\" }\n" +
                "  ],\n" +
                "  \"heading\": \"W\"\n" +
                "}");

        assertNotNull(emptyCrafted.getCraftContracts());

        assertTrue(emptyCrafted.getCraftContracts().isEmpty());

    }

    @Test
    public void getMen() throws Exception {

        assertNotNull(fullContext.getMen());
        assertEquals(12, fullContext.getMen());

    }

    @Test
    public void getBudget() throws Exception {

        assertNotNull(fullContext.getBudget());
        assertEquals(10000, fullContext.getBudget());

    }


}
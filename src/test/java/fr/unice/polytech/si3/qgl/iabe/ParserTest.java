package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.Resources.ResultParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 12/5/2016.
 */
public class ParserTest {

    private Bot bot;

    @Test
    public void getCost() throws Exception {

    }

    @Test
    public void getStatus() throws Exception {

    }

    @Test
    public void getRange() throws Exception {

    }

    @Test
    public void getFound() throws Exception {

    }

    @Test
    public void getBiomes() throws Exception {

    }

    @Test
    public void getCreeks() throws Exception {
        ResultParser parser = new ResultParser("{\"cost\": 2, \"extras\": { \"biomes\": [\"GLACIER\", \"ALPINE\"], \"creeks\": [], \"sites\": []}, \"status\": \"OK\"}");
        List<String> list = parser.getCreeks();
        assertTrue(list.isEmpty());
        parser = new ResultParser("{\"cost\": 2, \"extras\": { \"biomes\": [\"GLACIER\", \"ALPINE\"], \"creeks\": [\"id\"], \"sites\": []}, \"status\": \"OK\"}");
        list = parser.getCreeks();
        assertFalse(list.isEmpty());
    }

    @Test
    public void getSites() throws Exception {

    }

    @Test
    public void getResult(){


    }
}
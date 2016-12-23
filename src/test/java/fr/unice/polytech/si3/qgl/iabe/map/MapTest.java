package fr.unice.polytech.si3.qgl.iabe.map;

import fr.unice.polytech.si3.qgl.iabe.Bot;
import fr.unice.polytech.si3.qgl.iabe.Drone;
import fr.unice.polytech.si3.qgl.iabe.Direction;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.parser.ContextParser;
import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.Result;
import fr.unice.polytech.si3.qgl.iabe.result.ResultFactory;
import fr.unice.polytech.si3.qgl.iabe.strategy.Compass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static fr.unice.polytech.si3.qgl.iabe.Direction.*;
import static org.junit.Assert.*;

/**
 * Created by Enzo on 11/12/2016.
 */
public class MapTest {

    private Map map;
    private Drone drone;

    @Before
    public void setUp() throws Exception {
        ContextParser parser = new ContextParser("{ \"men\": 12, \"budget\": 10000,\n" +
                "  \"contracts\": [\n" +
                "    { \"amount\": 600, \"resource\": \"WOOD\" },\n" +
                "    { \"amount\": 200, \"resource\": \"GLASS\" }\n" +
                "  ],\n" +
                "  \"heading\": \"E\"\n" +
                "}");

        Bot bot = new Bot(parser);
        this.drone = new Drone(Direction.valueOf(parser.getHeading()));
        map = new Map(bot, drone);
    }

    @After
    public void tearDown() throws Exception {

    }

   /* @Test
    public void addWidth() throws Exception {
        map.addWidth(5);
        assertEquals(5, map.getSizeWidth());

        map.addWidth(5);
        assertEquals(10,map.getSizeWidth());

        map.setSizeHeight(10);
        assertEquals(10,map.getSizeHeight());

        map.addWidth(5);
        assertNotEquals(15,map.getSizeWidth());
    }
*/
/*    @Test
    public void createMap() throws Exception {
        map.addWidth(10);
        map.setSizeHeight(10);
        map.createMap();

        assertNotEquals(true, map.isDiscovered(Direction.E,0,0));
        assertEquals(false, map.isDiscovered(Direction.S,5,5));
        assertEquals(false, map.isDiscovered(Direction.E,10000,10000));
        assertEquals(false, map.isDiscovered(Direction.W,-50,-50));
    }*/


    @Test
    public void getMapTest() throws Exception {
        //System.out.println(map.toString());

        Compass compass = new Compass();
        Direction direction1 = compass.getRightOf(drone.getCurrentDirection());
        Direction direction2 = compass.getLeftOf(drone.getCurrentDirection());
        Echo firstEcho = new Echo(direction1);
        Echo secondEcho = new Echo(direction2);
        Echo thirdEcho = new Echo(drone.getCurrentDirection());

        Echo previous = firstEcho;
        ResultParser parser = new ResultParser("{ \"cost\": 1, \"extras\": { \"range\": 2, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        Result result = new ResultFactory(parser,previous).getResult();
        map.update(previous,result);
        //System.out.println(map.toString());

        previous = secondEcho;
        parser = new ResultParser("{ \"cost\": 1, \"extras\": { \"range\": 3, \"found\": \"GROUND\" }, \"status\": \"OK\" }");
        result = new ResultFactory(parser,previous).getResult();
        map.update(previous,result);
        //System.out.println(map.toString());

        previous = thirdEcho;
        parser = new ResultParser("{ \"cost\": 1, \"extras\": { \"range\": 8, \"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }");
        result = new ResultFactory(parser,previous).getResult();
        map.update(previous,result);
        //System.out.println(map.toString());

/*        previous = new Echo(S);
        parser = new ResultParser("{ \"cost\": 1, \"extras\": { \"range\": 3, \"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }");
        result = new ResultFactory(parser,previous).getResult();
        map.update(previous,result);
        //System.out.println(map.toString());*/

    }

    @Test
    public void getSizeWidth() throws Exception {

    }

    @Test
    public void actuMap() throws Exception {

    }

  /*  @Test
    public void isDiscovered() throws Exception {
        map.addWidth(10);
        map.setSizeHeight(10);
        map.createMap();

        assertNotEquals(true, map.isDiscovered(Direction.N,0,0));
        assertNotEquals(true, map.isDiscovered(Direction.W,0,0));

        assertEquals(false, map.isDiscovered(Direction.S,9,9));
        assertEquals(false, map.isDiscovered(Direction.E,9,9));

        assertEquals(false, map.isDiscovered(Direction.E,1,10000));
        assertEquals(false, map.isDiscovered(Direction.W,1,10000));
        assertEquals(false, map.isDiscovered(Direction.N,10000,1));
        assertEquals(false, map.isDiscovered(Direction.S,10000,1));

        assertNotEquals(true, map.isDiscovered(Direction.E,-50,-50));
        assertNotEquals(true, map.isDiscovered(Direction.W,-50,-50));
        assertNotEquals(true, map.isDiscovered(Direction.N,-50,-50));
        assertNotEquals(true, map.isDiscovered(Direction.S,-50,-50));

    }*/
}
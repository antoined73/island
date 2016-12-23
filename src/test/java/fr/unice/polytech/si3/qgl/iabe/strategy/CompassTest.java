package fr.unice.polytech.si3.qgl.iabe.strategy;

import fr.unice.polytech.si3.qgl.iabe.Bot;
import fr.unice.polytech.si3.qgl.iabe.Direction;
import fr.unice.polytech.si3.qgl.iabe.decisions.Decision;
import fr.unice.polytech.si3.qgl.iabe.parser.ContextParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static fr.unice.polytech.si3.qgl.iabe.Direction.*;
import static org.junit.Assert.*;

/**
 * Created by Antoine on 12/11/2016.
 */
public class CompassTest {

    private Compass compass;

    @Before
    public void setUp() throws Exception {
        this.compass = new Compass();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getRightOfEast() throws Exception {
        Direction[] dirArray = {E,N,W};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getRightOf(E)));
        assertEquals(compass.getRightOf(E),S);
    }

    @Test
    public void getRightOfSouth() throws Exception {
        Direction[] dirArray = {S,N,E};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getRightOf(S)));
        assertEquals(compass.getRightOf(S),W);
    }

    @Test
    public void getRightOfWest() throws Exception {
        Direction[] dirArray = {W,S,E};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getRightOf(W)));
        assertEquals(compass.getRightOf(W),N);
    }

    @Test
    public void getRightOfNorth() throws Exception {
        Direction[] dirArray = {N,S,W};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getRightOf(N)));
        assertEquals(compass.getRightOf(N),E);
    }

    @Test
    public void getLeftOfEast() throws Exception {
        Direction[] dirArray = {E,S,W};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getLeftOf(E)));
        assertEquals(compass.getLeftOf(E),N);
    }

    @Test
    public void getLeftOfSouth() throws Exception {
        Direction[] dirArray = {S,N,W};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getLeftOf(S)));
        assertEquals(compass.getLeftOf(S),E);
    }

    @Test
    public void getLeftOfWest() throws Exception {
        Direction[] dirArray = {W,N,E};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getLeftOf(W)));
        assertEquals(compass.getLeftOf(W),S);
    }

    @Test
    public void getLeftOfNorth() throws Exception {
        Direction[] dirArray = {N,S,E};
        List<Direction> directionsWeDontWant = Arrays.asList(dirArray);
        assertFalse(directionsWeDontWant.contains(compass.getLeftOf(N)));
        assertEquals(compass.getLeftOf(N),W);
    }

    @Test
    public void getLeftOf() throws Exception {

    }
}
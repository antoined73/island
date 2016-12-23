package fr.unice.polytech.si3.qgl.iabe.result;

import fr.unice.polytech.si3.qgl.iabe.Bot;
import fr.unice.polytech.si3.qgl.iabe.decisions.Echo;
import fr.unice.polytech.si3.qgl.iabe.decisions.Fly;
import fr.unice.polytech.si3.qgl.iabe.parser.ContextParser;
import fr.unice.polytech.si3.qgl.iabe.parser.ResultParser;
import fr.unice.polytech.si3.qgl.iabe.result.factories.EchoFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Antoine on 12/5/2016.
 */
public class ResultFactoryTest {

    private ResultFactory factory;
    @Before
    public void setUp() throws Exception {
        ResultParser parser = new ResultParser("{\"cost\": 2, \"extras\": { \"biomes\": [\"GLACIER\", \"ALPINE\"], \"creeks\": [\"id\"], \"sites\": []}, \"status\": \"OK\"}");
        new EchoFactory(parser);
        factory = new ResultFactory(parser,new Fly());
    }

//    @After
//    public void tearDown() throws Exception {
//
//    }
//
    @Test
    public void getResult() throws Exception {
       factory.getResult();
    }
}

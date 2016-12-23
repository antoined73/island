package fr.unice.polytech.si3.qgl.iabe;

import fr.unice.polytech.si3.qgl.iabe.decisions.*;
import fr.unice.polytech.si3.qgl.iabe.tools.JSONBuilder;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static fr.unice.polytech.si3.qgl.iabe.Direction.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Antoine on 12/8/2016.
 */
public class JSONBuilderTest {

    @Test
    public void getJSONObjectTest() throws Exception {
        System.out.println(Direction.valueOf("S"));

        //ECHO
        JSONObject jsonObject1 = JSONBuilder.getJSONObject(new Echo(E));
        JSONObject jsonObject2 = new JSONObject("{\"action\":\"echo\",\"parameters\":{\"direction\":\"E\"}}");
        JSONObject parameters1 = (JSONObject) jsonObject1.get("parameters");
        JSONObject parameters2 = (JSONObject) jsonObject2.get("parameters");
        assertEquals(jsonObject1.get("action"),jsonObject2.get("action"));
        assertEquals(parameters1.get("direction"),parameters2.get("direction"));

        //FLY
        jsonObject1 = JSONBuilder.getJSONObject(new Fly());
        jsonObject2 = new JSONObject("{\"action\":\"fly\"}");

        //STOP
        jsonObject1 = JSONBuilder.getJSONObject(new Stop());
        jsonObject2 = new JSONObject("{\"action\":\"stop\"}");
        assertEquals(jsonObject1.get("action"),jsonObject2.get("action"));

        //SCAN
        jsonObject1 = JSONBuilder.getJSONObject(new Scan());
        jsonObject2 = new JSONObject("{\"action\":\"scan\"}");
        assertEquals(jsonObject1.get("action"),jsonObject2.get("action"));

        //HEADING
        jsonObject1 = JSONBuilder.getJSONObject(new Heading(E));
        jsonObject2 = new JSONObject("{\"action\":\"heading\",\"parameters\":{\"direction\":\"E\"}}");
        parameters1 = (JSONObject) jsonObject1.get("parameters");
        parameters2 = (JSONObject) jsonObject2.get("parameters");
        assertEquals(jsonObject1.get("action"),jsonObject2.get("action"));
        assertEquals(parameters1.get("direction"),parameters2.get("direction"));
    }
}
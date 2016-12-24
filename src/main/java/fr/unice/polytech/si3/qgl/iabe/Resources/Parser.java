package fr.unice.polytech.si3.qgl.iabe.Resources;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 12/3/2016.
 */
public class    Parser {
    protected final JSONObject jsonObject;

    public Parser(String stringResults) {
        this.jsonObject = new JSONObject(stringResults);
    }
}

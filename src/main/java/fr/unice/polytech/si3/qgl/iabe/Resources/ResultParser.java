package fr.unice.polytech.si3.qgl.iabe.parser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 12/11/2016.
 */
public class ResultParser extends Parser{

    private final JSONObject jsonExtras;

    public ResultParser(String stringResults) {
        super(stringResults);
        this.jsonExtras = (JSONObject) jsonObject.get("extras");
    }

    public int getCost() {return jsonObject.getInt("cost");}

    public String getStatus() {
        return jsonObject.getString("status");
    }

    public int getRange() {
        return jsonExtras.getInt("range");
    }

    public String getFound() {
        return jsonExtras.getString("found");
    }

    public List<String> getBiomes() {
        JSONArray jsonArray = jsonExtras.getJSONArray("biomes");
        return extractListFromJSONArray(jsonArray);
    }

    public List<String> getCreeks() {
        JSONArray jsonArray = jsonExtras.getJSONArray("creeks");
        return extractListFromJSONArray(jsonArray);
    }

    public List<String> getSites() {
        JSONArray jsonArray = jsonExtras.getJSONArray("sites");
        return extractListFromJSONArray(jsonArray);
    }

    private List<String> extractListFromJSONArray(JSONArray jsonArray) {
        ArrayList<String> list = new ArrayList<String>();
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                list.add(jsonArray.get(i).toString());
            }
        }
        return list;
    }

}

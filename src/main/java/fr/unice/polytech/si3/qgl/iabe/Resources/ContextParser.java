package fr.unice.polytech.si3.qgl.iabe.Resources;

import fr.unice.polytech.si3.qgl.iabe.Resources.Crafted;
import fr.unice.polytech.si3.qgl.iabe.Resources.Primary;
import fr.unice.polytech.si3.qgl.iabe.Resources.Parser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static fr.unice.polytech.si3.qgl.iabe.Resources.Crafted.isCraftedRes;
import static fr.unice.polytech.si3.qgl.iabe.Resources.Crafted.toCrafted;
import static fr.unice.polytech.si3.qgl.iabe.Resources.Primary.isPrimaryRes;
import static fr.unice.polytech.si3.qgl.iabe.Resources.Primary.toPrimary;

/**
 * Created by Antoine on 12/11/2016.
 */
public class ContextParser extends Parser {

    private final JSONArray jsonContracts;

    public ContextParser(String stringResults) {
        super(stringResults);
        this.jsonContracts = jsonObject.getJSONArray("contracts");
    }

    public String getHeading() {
        return jsonObject.getString("heading");
    }

    public ArrayList<Primary> getPrimaryContracts() {

        ArrayList<Primary> res = new ArrayList<>();

        JSONObject contract;

        String resource = "";
        int amount = 0;


        for (int i = 0; i < jsonContracts.length(); i++) {

            contract = (JSONObject) jsonContracts.get(i);

            resource = contract.getString("resource");
            amount = contract.getInt("amount");

            if (isPrimaryRes(resource)) {

                toPrimary(contract.getString("resource")).getResource().setResourceContract(amount);

                res.add(toPrimary(contract.getString("resource")));

            }

        }


        return res;

    }

    public ArrayList<Crafted> getCraftContracts() {

        ArrayList<Crafted> res = new ArrayList<>();

        JSONObject contract;

        String resource = "";
        int amount = 0;


        for (int i = 0; i < jsonContracts.length(); i++) {

            contract = (JSONObject) jsonContracts.get(i);

            resource = contract.getString("resource");
            amount = contract.getInt("amount");

            if (isCraftedRes(resource)) {

                toCrafted(contract.getString("resource")).getResource().setResourceContract(amount);

                res.add(toCrafted(contract.getString("resource")));

            }

        }


        return res;

    }


    public int getMen() {
        return jsonObject.getInt("men");
    }

    public int getBudget() {
        return jsonObject.getInt("budget");
    }


}

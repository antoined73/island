package fr.unice.polytech.si3.qgl.iabe.Resources;

import java.util.*;

import static fr.unice.polytech.si3.qgl.iabe.Resources.Primary.*;

/**
 * Created by Olivier on 15/12/2016.
 */
public enum Crafted {

    GLASS("GLASS", new ArrayList<Primary>() {{
        add(QUARTZ);
        add(WOOD);
    }}, new ArrayList<Integer>() {{
        add(10);
        add(5);
    }}, new Resources()),
    INGOT("INGOT", new ArrayList<Primary>() {{
        add(ORE);
        add(WOOD);
    }}, new ArrayList<Integer>() {{
        add(5);
        add(5);
    }}, new Resources()),
    LEATHER("LEATHER", new ArrayList<Primary>() {{
        add(FUR);
    }}, new ArrayList<Integer>() {{
        add(3);
    }}, new Resources()),
    PLANK("PLANCK", new ArrayList<Primary>() {{
        add(WOOD);
    }}, new ArrayList<Integer>() {{
        add(1);
    }}, new Resources()),
    RUM("RUM", new ArrayList<Primary>() {{
        add(SUGAR_CANE);
        add(FRUITS);
    }}, new ArrayList<Integer>() {{
        add(10);
        add(1);
    }}, new Resources());


    private final String res;

    private final EnumMap<Primary, Integer> recipe;

    private final Resources resource;

    static final Map<String, Crafted> STRING_CRAFTED_MAP = new HashMap<>();

    Crafted(String res, List<Primary> primaries, List<Integer> amount, Resources resource) {

        this.res = res;

        recipe = new EnumMap<>(Primary.class);

        for (int i = 0; i < primaries.size() && i < amount.size(); i++) {

            recipe.put(primaries.get(i), amount.get(i));

        }

        this.resource = resource;

    }

    static {

        Arrays.asList(Crafted.values()).forEach(cw -> STRING_CRAFTED_MAP.put(cw.toString(), cw));

    }


    /**
     * Check whether a given String is a valid name word or not.
     *
     * @param aString The string to be checked.
     * @return true if it is valid, false if it isn't.
     */
    public static boolean isCraftedRes(String aString) {

        if (aString != null) {

            return STRING_CRAFTED_MAP.containsKey(aString);

        }

        return false;

    }

    public static Crafted toCrafted(String word) {

        return STRING_CRAFTED_MAP.get(word);


    }

    public Resources getResource() {
        return resource;
    }


}

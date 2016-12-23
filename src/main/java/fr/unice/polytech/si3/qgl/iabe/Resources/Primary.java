package fr.unice.polytech.si3.qgl.iabe.Resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olivier on 15/12/2016.
 */
public enum Primary {

    FISH("FISH", new Resources()),
    FLOWER("FLOWER", new Resources()),
    FRUITS("FRUITS", new Resources()),
    FUR("FUR", new Resources()),
    ORE("ORE", new Resources()),
    QUARTZ("QUARTZ", new Resources()),
    SUGAR_CANE("SUGAR_CANE", new Resources()),
    WOOD("WOOD", new Resources());


    private final String res;
    private final Resources resource;

    static final Map<String, Primary> STRING_PRIMARY_MAP = new HashMap<>();

    Primary(String res, Resources primaryRes) {

        this.res = res;
        this.resource = primaryRes;

    }

    static {

        Arrays.asList(Primary.values()).forEach(cw -> STRING_PRIMARY_MAP.put(cw.toString(), cw));

    }


    /**
     * Check whether a given String is a valid name word or not.
     *
     * @param aString The string to be checked.
     * @return true if it is valid, false if it isn't.
     */
    public static boolean isPrimaryRes(String aString) {

        if (aString != null) {

            return STRING_PRIMARY_MAP.containsKey(aString);

        }

        return false;

    }

    public static Primary toPrimary(String word) {

        return STRING_PRIMARY_MAP.get(word);


    }

    public Resources getResource() {
        return resource;
    }
}

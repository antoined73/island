package fr.unice.polytech.si3.qgl.iabe.Resources;

import static fr.unice.polytech.si3.qgl.iabe.Resources.Crafted.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Olivier on 23/12/2016.
 */
public class CraftedTest {

    @Test
    public void isCraftedResTest() throws Exception {

        assertTrue(isCraftedRes("GLASS"));
        assertTrue(isCraftedRes("INGOT"));
        assertTrue(isCraftedRes("LEATHER"));
        assertTrue(isCraftedRes("PLANK"));
        assertTrue(isCraftedRes("RUM"));

        assertFalse(isCraftedRes("JE NE SUIS PAS UNE CRAFT"));
        assertFalse(isCraftedRes("WOOD"));
        assertFalse(isCraftedRes("glass"));
        assertFalse(isCraftedRes(""));

    }

    @Test
    public void toCraftedTest() throws Exception {

        assertEquals(Crafted.class, toCrafted("GLASS").getClass());
        assertEquals(Crafted.class, toCrafted("INGOT").getClass());
        assertEquals(Crafted.class, toCrafted("LEATHER").getClass());
        assertEquals(Crafted.class, toCrafted("PLANK").getClass());
        assertEquals(Crafted.class, toCrafted("RUM").getClass());

        assertNotEquals(Crafted.class, toCrafted("LOL"));
        assertNotEquals(Crafted.class, toCrafted("WOOD"));
        assertNotEquals(Crafted.class, toCrafted(""));

    }


}
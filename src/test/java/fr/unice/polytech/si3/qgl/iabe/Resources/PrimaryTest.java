package fr.unice.polytech.si3.qgl.iabe.Resources;

import org.junit.Test;

import static fr.unice.polytech.si3.qgl.iabe.Resources.Primary.isPrimaryRes;
import static fr.unice.polytech.si3.qgl.iabe.Resources.Primary.toPrimary;
import static org.junit.Assert.*;

/**
 * Created by Olivier on 23/12/2016.
 */
public class PrimaryTest {
    @Test
    public void isPrimaryResTest() throws Exception {

        assertTrue(isPrimaryRes("FISH"));
        assertTrue(isPrimaryRes("FLOWER"));
        assertTrue(isPrimaryRes("FRUITS"));
        assertTrue(isPrimaryRes("FUR"));
        assertTrue(isPrimaryRes("ORE"));
        assertTrue(isPrimaryRes("QUARTZ"));
        assertTrue(isPrimaryRes("SUGAR_CANE"));
        assertTrue(isPrimaryRes("WOOD"));

        assertFalse(isPrimaryRes("JE NE SUIS PAS UNE PRIMARY"));
        assertFalse(isPrimaryRes("GLASS"));
        assertFalse(isPrimaryRes("wood"));
        assertFalse(isPrimaryRes(""));

    }

    @Test
    public void toPrimaryTest() throws Exception {

        assertEquals(Primary.class, toPrimary("FISH").getClass());
        assertEquals(Primary.class, toPrimary("FLOWER").getClass());
        assertEquals(Primary.class, toPrimary("FRUITS").getClass());
        assertEquals(Primary.class, toPrimary("FUR").getClass());
        assertEquals(Primary.class, toPrimary("ORE").getClass());
        assertEquals(Primary.class, toPrimary("QUARTZ").getClass());
        assertEquals(Primary.class, toPrimary("SUGAR_CANE").getClass());
        assertEquals(Primary.class, toPrimary("WOOD").getClass());

        assertNotEquals(Crafted.class, toPrimary("LOL"));
        assertNotEquals(Crafted.class, toPrimary("GLASS"));
        assertNotEquals(Crafted.class, toPrimary("wood"));
        assertNotEquals(Crafted.class, toPrimary(""));

    }

}
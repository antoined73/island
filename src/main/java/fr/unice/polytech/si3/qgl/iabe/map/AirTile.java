package fr.unice.polytech.si3.qgl.iabe.map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Antoine on 12/3/2016.
 */
public class AirTile {
    private EarthTile[][] airTile;
    private boolean isDiscovered = false;
    private int xPos, yPos;

    public AirTile(int xPos, int yPos) {
        this.airTile = new EarthTile[3][3];
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered(boolean discovered) {
        this.isDiscovered = discovered;
    }

    public boolean isGround() {
        throw new NotImplementedException();
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }
}

package fr.unice.polytech.si3.qgl.iabe.map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Antoine on 12/3/2016.
 */
public class AirTile {
    private EarthTile[][] airTile;
    private int xPos, yPos;
    private boolean containGround = false;
    private boolean isBorder = false;

    public AirTile(int xPos, int yPos) {
        this.airTile = new EarthTile[3][3];
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public AirTile(int xPos, int yPos, boolean isBorder) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isBorder = isBorder;
    }


    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setContainGround(boolean containGround) {
        this.containGround = containGround;
    }

    public boolean containGround() {
        return containGround;
    }

    public void setIsBorder(boolean isBorder) {
        this.isBorder = isBorder;
    }

    public boolean isBorder() {
        return isBorder;
    }
}

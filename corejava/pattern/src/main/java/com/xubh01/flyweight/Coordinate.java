package com.xubh01.flyweight;

/**
 * 外部状态UnSharedConcreteFlyWeight
 */
public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

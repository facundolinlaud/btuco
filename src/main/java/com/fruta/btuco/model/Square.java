package com.fruta.btuco.model;

/**
 * Created by facundo on 12/17/15.
 */
public class Square {
    private int startX;
    private int startY;
    private int size;

    public Square() {}

    public Square(int startX, int startY, int size) {
        this.startX = startX;
        this.startY = startY;
        this.size = size;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Square{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", size=" + size +
                '}';
    }
}
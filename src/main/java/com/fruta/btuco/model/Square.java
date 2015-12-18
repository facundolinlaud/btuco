package com.fruta.btuco.model;

import java.awt.*;

/**
 * Created by facundo on 12/17/15.
 */
public class Square {
    private int startX;
    private int startY;
    private int width;
    private int height;

    public Square() {}

    public Square(int startX, int startY, int width, int height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getCenter(){
        int x = startX + (width / 2);
        int y = startY + (height / 2);

        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Square{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
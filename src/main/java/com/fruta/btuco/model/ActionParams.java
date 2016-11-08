package com.fruta.btuco.model;

/**
 * Created by facundo on 12/17/15.
 */
public class ActionParams {
    private int faceCoveragePercent;
    private int pictureSize;
    private boolean colorized;

    public ActionParams(int faceCoveragePercent, int pictureSize, boolean colorized) {
        this.faceCoveragePercent = faceCoveragePercent;
        this.pictureSize = pictureSize;
        this.colorized = colorized;
    }

    public int getFaceCoveragePercent() {
        return faceCoveragePercent;
    }

    public void setFaceCoveragePercent(int faceCoveragePercent) {
        this.faceCoveragePercent = faceCoveragePercent;
    }

    public int getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(int pictureSize) {
        this.pictureSize = pictureSize;
    }

    public boolean isColorized() {
        return colorized;
    }

    public void setColorized(boolean colorized) {
        this.colorized = colorized;
    }

    @Override
    public String toString() {
        return "ActionParams{" +
                "faceCoveragePercent=" + faceCoveragePercent +
                ", pictureSize=" + pictureSize +
                ", colorized=" + colorized +
                '}';
    }
}

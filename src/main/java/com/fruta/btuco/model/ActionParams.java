package com.fruta.btuco.model;

/**
 * Created by facundo on 12/17/15.
 */
public class ActionParams {
    private int faceCoveragePercent;
    private int pictureSize;

    public ActionParams(int faceCoveragePercent, int pictureSize) {
        this.faceCoveragePercent = faceCoveragePercent;
        this.pictureSize = pictureSize;
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

    @Override
    public String toString() {
        return "ActionParams{" +
                "faceCoveragePercent=" + faceCoveragePercent +
                ", pictureSize=" + pictureSize +
                '}';
    }
}

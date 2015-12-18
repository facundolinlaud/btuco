package com.fruta.btuco.model;

/**
 * Created by facundo on 12/17/15.
 */
public class ActionParams {
    private Integer faceWidth;
    private Integer faceHeight;
    private Integer pictureWidth;
    private Integer pictureHeight;

    public ActionParams() {}

    public ActionParams(Integer faceWidth, Integer faceHeight, Integer pictureWidth, Integer pictureHeight) {
        this.faceWidth = faceWidth;
        this.faceHeight = faceHeight;
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    public Integer getFaceWidth() {
        return faceWidth;
    }

    public void setFaceWidth(Integer faceWidth) {
        this.faceWidth = faceWidth;
    }

    public Integer getFaceHeight() {
        return faceHeight;
    }

    public void setFaceHeight(Integer faceHeight) {
        this.faceHeight = faceHeight;
    }

    public Integer getPictureWidth() {
        return pictureWidth;
    }

    public void setPictureWidth(Integer pictureWidth) {
        this.pictureWidth = pictureWidth;
    }

    public Integer getPictureHeight() {
        return pictureHeight;
    }

    public void setPictureHeight(Integer pictureHeight) {
        this.pictureHeight = pictureHeight;
    }

    @Override
    public String toString() {
        return "ActionParams{" +
                "faceWidth=" + faceWidth +
                ", faceHeight=" + faceHeight +
                '}';
    }
}

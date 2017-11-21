package com.flowacademy.Media;

public class VideoClip extends Mp3 {
    protected int imageWidth;
    protected int imageHeight;

    public VideoClip(String artist, String album, String title, int duration, int imageWidth, int imageHeight) {
        super(artist, album, title, duration);
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }


    @Override
    public String toString() {
        return super.toString() + ", képmérete pedig " +
                imageWidth + ':' + imageHeight;
    }
}

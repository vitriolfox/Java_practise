package com.flowacademy.Media;

public class Mp3 {
    protected String artist;
    protected String album;
    protected String title;
    protected int duration;

    public Mp3(String artist, String album, String title, int duration) {
        this.artist = artist;
        this.album = album;
        this.title = title;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Ez a " + title + " a " + artist + " előadótól ami az " + album + " albumon található, " +
                "hossza pedig " + duration;
    }

}

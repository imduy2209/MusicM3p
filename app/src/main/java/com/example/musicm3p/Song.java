package com.example.musicm3p;

import java.io.Serializable;

public class Song implements Serializable {
    private final String songName;
    private final String artistName;
    private int songImageResourceId;
    private int songResourceId;
    private final String lyrics;

    public Song(String songName, String artistName, int songImageResourceId, int songResourceId, String lyrics) {
        this.songName = songName;
        this.artistName = artistName;
        this.songImageResourceId = songImageResourceId;
        this.songResourceId = songResourceId;
        this.lyrics = lyrics;
    }

    // Getter methods...

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getSongImageResourceId() {
        return songImageResourceId;
    }

    public int getSongResourceId() {
        return songResourceId;
    }

    public String getLyrics() {
        return lyrics;
    }
}

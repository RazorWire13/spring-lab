package com.rw13.springlab;

import javax.persistence.*;

@Entity
public class Song {

    // Song Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public int trackNumber;
    public int length;


    @ManyToOne
    public Album album;

    // Song Constructors
    public Song() {}
    public Song(String title, int trackNumber, int length) {
        this.title = title;
        this.trackNumber = trackNumber;
        this.length = length;
    }

    // Data return as string
    public String toString() {
        return "Song Title: " + title + " || Track: " + trackNumber + " || Length: " + length + " sec";
    }
}

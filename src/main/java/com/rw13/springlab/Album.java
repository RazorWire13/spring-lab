package com.rw13.springlab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public String artist;
    public int songCount;
    public int length;
    public String imageUrl;

    // Constructors
    public Album() {}
    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    // Data return as string
    public String toString() {
        return "Title: " + title + " | Artist: " + artist + " | Songcount: " + songCount + " | Length: " + length + "min | Album Image: " + imageUrl;
    }

}

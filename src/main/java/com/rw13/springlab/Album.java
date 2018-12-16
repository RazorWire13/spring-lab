package com.rw13.springlab;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    // Album Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public String artist;
    public int songCount;
    public int length;
    public String imageUrl;

    @OneToMany (mappedBy = "album")
    public List<Song> songs;

    // Album Constructors
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
        return "Title: " + title + " || Artist: " + artist + " || Songcount: " + songCount + " || Length: " + length + "min || Album Image --> " + imageUrl;
    }

}

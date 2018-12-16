package com.rw13.springlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private SongRepository songRepo;

    // Database display
    @RequestMapping(value="/albums", method=RequestMethod.GET)
    public String index(Model model) {
        // Display album info on screen
        model.addAttribute("albums", albumRepo.findAll());
        return "albumIndex";
    }

    // Takes in user data and adds an album to the album database
    @RequestMapping(value="/albums", method=RequestMethod.POST)
    public RedirectView createAlbum(
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam int songCount,
            @RequestParam int length,
            @RequestParam String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepo.save(newAlbum);
        return new RedirectView("/albums");
    }

    // Takes in user data and adds a song to the song database
    @RequestMapping(value="/albums/{albumId}/songs", method=RequestMethod.POST)
    public RedirectView addSong(@PathVariable long albumId,
                                @RequestParam String title,
                                @RequestParam int trackNumber,
                                @RequestParam int length,
                                Model model) {
        Song newSong = new Song(title, trackNumber, length);
        newSong.album = albumRepo.findById(albumId).get();
        songRepo.save(newSong);
        return new RedirectView("/albums");
    }
}

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
public class SongController {

    @Autowired
    private SongRepository songRepo;

    // Database display
    @RequestMapping(value="/songs", method=RequestMethod.GET)
    public String index(Model model) {
        // Display song info on screen
        model.addAttribute("songs", songRepo.findAll());
        return "songIndex";
    }

    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public RedirectView createSong(
            @RequestParam String title,
            @RequestParam int trackNumber,
            @RequestParam int length,
            Model model) {
        Song newSong = new Song(title, trackNumber, length);
            songRepo.save(newSong);
            return new RedirectView("/songs");
    }
}

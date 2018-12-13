package com.rw13.springlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepo;

    @RequestMapping(value="/albums", method=RequestMethod.GET)
    public String index(Model model) {
        // get albums
//        Album[] albums = new Album[] {
//                new Album("The Jester Race", "In Flames", 10, 40, "https://en.wikipedia.org/wiki/File:In_Flames-The_Jester_Race.jpg"),
//                new Album("Perseverance", "Hatebreed", 16, 38, "https://en.wikipedia.org/wiki/File:Hatebreed_-_Perseverance_2003.jpg"),
//                new Album("Love Death Immortality", "The Glitch Mob", 10, 52, "https://en.wikipedia.org/wiki/File:The_Glitch_Mob_-_Love_Death_Immortality.jpg")
//        };

        //display albums on page
        model.addAttribute("albums", albumRepo.findAll());
        return "albumIndex";
    }

    @RequestMapping(value="albums", method=RequestMethod.POST)
    public RedirectView create(Model model) {
        Album newAlbum = new Album("The Jester Race", "In Flames", 10, 40, "https://en.wikipedia.org/wiki/File:In_Flames-The_Jester_Race.jpg");
        albumRepo.save(newAlbum);
        return new RedirectView("/albums");
    }
}

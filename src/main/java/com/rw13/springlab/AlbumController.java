package com.rw13.springlab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlbumController {

    @RequestMapping(value="/heythere/{phrase}", method= RequestMethod.GET)
    public String heyThere(@PathVariable() String phrase, Model model) {
        model.addAttribute("phrase", phrase);
        return "heyThere";
    }
}

package com.rw13.springlab;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String helloWorld() {

        return "Hello World!";
    }

    @RequestMapping(value="/capitalize/{phrase}", method= RequestMethod.GET)
    public String upperCaseify(@PathVariable() String phrase) {
        return phraseToCaps(phrase);
    }

    public static String phraseToCaps(String phrase) {

        return phrase.toUpperCase();
    }
}

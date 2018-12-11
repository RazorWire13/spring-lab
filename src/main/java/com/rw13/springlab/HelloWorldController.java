package com.rw13.springlab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/capitalize/hello")
    public String nameToCaps(@RequestParam(name="name", required=false) String name) {
        return phraseToCaps(name);
    }

    public static String phraseToCaps(String phrase) {
        return phrase.toUpperCase();
    }
}

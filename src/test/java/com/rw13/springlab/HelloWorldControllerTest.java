package com.rw13.springlab;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldControllerTest {

    @Test
    public void phraseToCapsLower() {
        String phrase = "what up";
        String expected = "WHAT UP";
        String actual = HelloWorldController.phraseToCaps(phrase);
    assertEquals("phraseToCaps will return an all CAPS", expected, actual);
    }

    @Test
    public void phraseToCapsMixed() {
        String phrase = "wHaT uP";
        String expected = "WHAT UP";
        String actual = HelloWorldController.phraseToCaps(phrase);
        assertEquals("phraseToCaps will return an all CAPS", expected, actual);
    }

    @Test
    public void phraseToCapsAllCaps() {
        String phrase = "WHAT UP";
        String expected = "WHAT UP";
        String actual = HelloWorldController.phraseToCaps(phrase);
        assertEquals("phraseToCaps will return an all CAPS", expected, actual);
    }
}
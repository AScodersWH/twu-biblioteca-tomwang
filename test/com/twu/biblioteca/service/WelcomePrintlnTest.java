package com.twu.biblioteca.service;

import com.twu.biblioteca.service.WelcomePrintln;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomePrintlnTest {

    @Test
    public void test_Welcome() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        WelcomePrintln welcomePrintln = new WelcomePrintln();
        welcomePrintln.welcome();

        assertEquals("Hello World!\n" +
                "\n" +
                "***********************************\n" +
                "you can have below choices\n" +
                "\n" +
                "\n" +
                "1:look for books\n" +
                "2:look for books with details\n" +
                "3:choose a book you want\n" +
                "4:input your return infos\n" +
                "5:look for movies\n" +
                "6:check out a movie\n" +
                "0:exit system\n", outContent.toString());
    }

}

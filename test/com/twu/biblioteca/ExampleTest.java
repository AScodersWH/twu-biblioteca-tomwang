package com.twu.biblioteca;


import com.twu.biblioteca.untils.WelcomePrintln;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcome() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        WelcomePrintln welcomePrintln = new WelcomePrintln();
        welcomePrintln.welcome();

        assertEquals("Hello World!", outContent.toString());
    }

}

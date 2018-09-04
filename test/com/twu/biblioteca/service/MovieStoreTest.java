package com.twu.biblioteca.service;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class MovieStoreTest {

    @Test
    public void shouldInitialMoviesWithDetailsSuccess() {
        MovieStore movieStore = new MovieStore();
        movieStore.initialMoviesWithDetails();

        List<String> testMovies = new ArrayList<String>();
        testMovies.add("KunfuPanda-----year:2012-----director:Alis-------rating:9.2");
        testMovies.add("SpyderMan------year:2013-----director:Jam--------rating:8.7");
        testMovies.add("SonOfSon-------year:2009-----director:Sam--------rating:9.2");
        testMovies.add("ThreePigs------year:2007-----director:Stack------rating:9.0");

        assertEquals(movieStore.moviesWithDetails,testMovies);
    }

    @Test
    public void shouldCheckoutSuccess(){
        MovieStore movieStore = new MovieStore();
        movieStore.initialMoviesWithDetails();

        assertEquals(movieStore.checkoutMovie("KunfuPanda-----year:2012-----director:Alis-------rating:9.2")
        ,"Thank you! Enjoy the movie.");
    }
    @Test
    public void shouldCheckoutFail(){
        MovieStore movieStore = new MovieStore();
        movieStore.initialMoviesWithDetails();

        assertEquals(movieStore.checkoutMovie("KunfuPanda")
                ,"That movie is not available.");
    }

    @Test
    public void shouldShowMoviesWithDetails(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MovieStore movieStore = new MovieStore();
        movieStore.initialMoviesWithDetails();
        movieStore.showBooks(movieStore.moviesWithDetails);

        assertEquals(outContent.toString(),"KunfuPanda-----year:2012-----director:Alis-------rating:9.2\n" +
                "SpyderMan------year:2013-----director:Jam--------rating:8.7\n" +
                "SonOfSon-------year:2009-----director:Sam--------rating:9.2\n" +
                "ThreePigs------year:2007-----director:Stack------rating:9.0\n");
    }
}
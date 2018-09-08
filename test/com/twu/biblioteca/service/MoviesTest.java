package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movies;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.untils.MoviesInfo.KunfuPanda;
import static com.twu.biblioteca.untils.MoviesInfo.SonOfSon;
import static com.twu.biblioteca.untils.MoviesInfo.SpyderMan;
import static com.twu.biblioteca.untils.MoviesInfo.ThreePigs;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class MoviesTest {

    @Test
    public void shouldInitialMoviesWithDetailsSuccess() {
        Movies movies = new Movies();
        MovieService movieService = new MovieService();

        movieService.initialMoviesWithDetails(movies);

        List<String> testMovies = new ArrayList<String>();
        testMovies.add(KunfuPanda);
        testMovies.add(SpyderMan);
        testMovies.add(SonOfSon);
        testMovies.add(ThreePigs);

        assertEquals(movies.moviesWithDetails,testMovies);
    }

    @Test
    public void shouldCheckoutSuccess(){
        Movies movies = new Movies();
        MovieService movieService = new MovieService();
        movieService.initialMoviesWithDetails(movies);

        assertEquals(movieService.checkoutMovie(movies,KunfuPanda)
        ,"Thank you! Enjoy the movie.");
    }
    @Test
    public void shouldCheckoutFail(){
        MovieService movieService = new MovieService();

        Movies movies = new Movies();
        movieService.initialMoviesWithDetails(movies);

        assertEquals(movieService.checkoutMovie(movies,"KunfuPanda")
                ,"That movie is not available.");
    }

    @Test
    public void shouldShowMoviesWithDetails(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        MovieService movieService = new MovieService();

        Movies movies = new Movies();
        movieService.initialMoviesWithDetails(movies);
        movieService.showBooks(movies.moviesWithDetails);

        assertEquals(outContent.toString(),KunfuPanda+"\n" +
                SpyderMan+"\n" +
                SonOfSon+"\n" +
                ThreePigs+"\n");
    }
}
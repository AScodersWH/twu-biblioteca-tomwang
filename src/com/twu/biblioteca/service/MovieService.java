package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movies;

import java.util.List;

import static com.twu.biblioteca.untils.MoviesInfo.KunfuPanda;
import static com.twu.biblioteca.untils.MoviesInfo.SonOfSon;
import static com.twu.biblioteca.untils.MoviesInfo.SpyderMan;
import static com.twu.biblioteca.untils.MoviesInfo.ThreePigs;

public class MovieService {
    public List<String> initialMoviesWithDetails(Movies movies) {
        movies.moviesWithDetails.add(KunfuPanda);
        movies.moviesWithDetails.add(SpyderMan);
        movies.moviesWithDetails.add(SonOfSon);
        movies.moviesWithDetails.add(ThreePigs);
        return movies.moviesWithDetails;
    }

    public String checkoutMovie(Movies movies,String movieChosed) {
        for (int i = 0; i < movies.moviesWithDetails.size(); i++) {
            if (movies.moviesWithDetails.get(i).equals(movieChosed)) {
                return "Thank you! Enjoy the movie.";
            }
        }
        return "That movie is not available.";
    }

    public void showBooks(List<String> allMovies) {
        for (String s : allMovies) {
            System.out.println(s);
        }
    }
}

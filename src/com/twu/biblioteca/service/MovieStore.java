package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    public List<String> moviesWithDetails = new ArrayList<String>();

    public List<String> initialMoviesWithDetails() {
        moviesWithDetails.add("KunfuPanda-----year:2012-----director:Alis-------rating:9.2");
        moviesWithDetails.add("SpyderMan------year:2013-----director:Jam--------rating:8.7");
        moviesWithDetails.add("SonOfSon-------year:2009-----director:Sam--------rating:9.2");
        moviesWithDetails.add("ThreePigs------year:2007-----director:Stack------rating:9.0");
        return moviesWithDetails;
    }

    public String checkoutMovie(String movieChosed) {
        for (int i = 0; i < moviesWithDetails.size(); i++) {
            if (moviesWithDetails.get(i).equals(movieChosed)) {
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

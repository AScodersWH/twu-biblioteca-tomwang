package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    List<String> books = new ArrayList<String>();
    public List<String> booksWithDetails = new ArrayList<String>();


    public List<String> initialBooks(){
        books.add("Harry Potter");
        books.add("Sea");
        books.add("Sun");
        books.add("Three guns");
        books.add("Sam Ports");
        return books;
    }

    public List<String> initialBooksWithDetails(){
        booksWithDetails.add("Harry Potter     author: JK      time: 2012.12.28      version:  1");
        booksWithDetails.add("Sea              author: David   time: 2013.11.12      version:  1");
        booksWithDetails.add("Sun              author: Sam     time: 2009.02.09      version:  1");
        booksWithDetails.add("Three guns       author: Jan     time: 2007:01.22      version:  1");
        booksWithDetails.add("Sam Ports        author: Aus     time: 2015.12.01      version:  1");
        return booksWithDetails;
    }


    public void showBooks(List<String> allBooks) {

        for(String s: allBooks){
            System.out.println(s);
        }
    }



}
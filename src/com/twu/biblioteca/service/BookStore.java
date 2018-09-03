package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    public List<String> books = new ArrayList<String>();
    public List<String> booksWithDetails = new ArrayList<String>();


    public List<String> initialBooks() {
        books.add("1: Harry Potter");
        books.add("2: Sea");
        books.add("3: Sun");
        books.add("4: Three guns");
        books.add("5: Sam Ports");
        return books;
    }

    public List<String> initialBooksWithDetails() {
        booksWithDetails.add("1: Harry Potter     author: JK      time: 2012.12.28      version:  1");
        booksWithDetails.add("2: Sea              author: David   time: 2013.11.12      version:  1");
        booksWithDetails.add("3: Sun              author: Sam     time: 2009.02.09      version:  1");
        booksWithDetails.add("4: Three guns       author: Jan     time: 2007:01.22      version:  1");
        booksWithDetails.add("5: Sam Ports        author: Aus     time: 2015.12.01      version:  1");
        return booksWithDetails;
    }

    public String deleteBook(Integer book) {
        if (books.size() > book - 1) {
            books.remove(books.get(book - 1));
            booksWithDetails.remove(booksWithDetails.get(book - 1));
            return "Thank you! Enjoy the book.";
        } else return "That book is not available.";
    }

    public void showBooks(List<String> allBooks) {

        for (String s : allBooks) {
            System.out.println(s);
        }
    }


}

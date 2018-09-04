package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    public List<String> books = new ArrayList<String>();
    public List<String> booksWithDetails = new ArrayList<String>();


    public List<String> initialBooks() {
        books.add("HarryPotter");
        books.add("Sea");
        books.add("Sun");
        books.add("ThreeGuns");
        books.add("SamPorts");
        return books;
    }

    public List<String> initialBooksWithDetails() {
        booksWithDetails.add("HarryPotter-----author:JK------time:2012.12.28------version:1");
        booksWithDetails.add("Sea-------------author:David---time:2013.11.12------version:1");
        booksWithDetails.add("Sun-------------author:Sam-----time:2009.02.09------version:1");
        booksWithDetails.add("ThreeGuns-------author:Jan-----time:2007:01.22------version:1");
        booksWithDetails.add("SamPorts--------author:Aus-----time:2015.12.01------version:1");
        return booksWithDetails;
    }

    public String deleteBook(String bookToLend) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(bookToLend)) {
                books.remove(books.get(i));
                booksWithDetails.remove(booksWithDetails.get(i));
                return "Thank you! Enjoy the book.";
            }
        }
        return "That book is not available.";
    }

    public void showBooks(List<String> allBooks) {

        for (String s : allBooks) {
            System.out.println(s);
        }
    }

    public String returnBook(String bookReturn, String booksWithDetialsToreturn) {
        for (String s : books) {
            if (s.equals(bookReturn)) return "That is not a valid book to return.";
        }
        for (String sp : booksWithDetails) {
            if (sp.equals(booksWithDetialsToreturn)) return "That is not a valid book to return.";
        }
        books.add(bookReturn);
        booksWithDetails.add(booksWithDetialsToreturn);
        return "Thank you for returning the book.";
    }


}

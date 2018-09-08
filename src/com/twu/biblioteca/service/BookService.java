package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Books;

import java.util.List;

import static com.twu.biblioteca.untils.BooksInfo.HarryPoter;
import static com.twu.biblioteca.untils.BooksInfo.SamPorts;
import static com.twu.biblioteca.untils.BooksInfo.Sea;
import static com.twu.biblioteca.untils.BooksInfo.Sun;
import static com.twu.biblioteca.untils.BooksInfo.ThreeGuns;

public class BookService {

    public List<String> initialBooks(Books books) {
        books.books.add("HarryPotter");
        books.books.add("Sea");
        books.books.add("Sun");
        books.books.add("ThreeGuns");
        books.books.add("SamPorts");
        return books.books;
    }

    public List<String> initialBooksWithDetails(Books books) {
        books.booksWithDetails.add(HarryPoter);
        books.booksWithDetails.add(Sea);
        books.booksWithDetails.add(Sun);
        books.booksWithDetails.add(ThreeGuns);
        books.booksWithDetails.add(SamPorts);
        return books.booksWithDetails;
    }

    public String deleteBook(Books books, String bookToLend) {
        for (int i = 0; i < books.books.size(); i++) {
            if (books.books.get(i).equals(bookToLend)) {
                books.books.remove(books.books.get(i));
                books.booksWithDetails.remove(books.booksWithDetails.get(i));
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

    public String returnBook(Books books, String bookReturn, String booksWithDetialsToreturn) {
        for (String s : books.books) {
            if (s.equals(bookReturn)) return "That is not a valid book to return.";
        }
        for (String sp : books.booksWithDetails) {
            if (sp.equals(booksWithDetialsToreturn)) return "That is not a valid book to return.";
        }
        books.books.add(bookReturn);
        books.booksWithDetails.add(booksWithDetialsToreturn);
        return "Thank you for returning the book.";
    }


}

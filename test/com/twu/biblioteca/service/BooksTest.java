package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Books;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.untils.BooksInfo.HarryPoter;
import static com.twu.biblioteca.untils.BooksInfo.SamPorts;
import static com.twu.biblioteca.untils.BooksInfo.Sea;
import static com.twu.biblioteca.untils.BooksInfo.Spo;
import static com.twu.biblioteca.untils.BooksInfo.Sun;
import static com.twu.biblioteca.untils.BooksInfo.ThreeGuns;
import static org.junit.Assert.assertEquals;

public class BooksTest {

    @Test
    public void test_should_show_all_books() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Books books = new Books();
        BookService bookService = new BookService();
        bookService.showBooks(bookService.initialBooks(books));

        assertEquals("HarryPotter\n" + "Sea\n" + "Sun\n" +
                "ThreeGuns\n" + "SamPorts\n", outContent.toString());

    }

    @Test
    public void test_should_show_all_books_with_details() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Books books = new Books();
        BookService bookService = new BookService();

        bookService.showBooks(bookService.initialBooksWithDetails(books));

        assertEquals(HarryPoter+"\n" + Sea+"\n" + Sun+"\n" +
                        ThreeGuns+"\n" + SamPorts+"\n", outContent.toString());

    }

    @Test
    public void test_should_return_books(){
        Books books = new Books();
        BookService bookService = new BookService();

        List<String> testBooks = new ArrayList<String>();
        testBooks.add("HarryPotter");
        testBooks.add("Sea");
        testBooks.add("Sun");
        testBooks.add("ThreeGuns");
        testBooks.add("SamPorts");
        assertEquals(testBooks, bookService.initialBooks(books));
    }

    @Test
    public void test_should_return_booksWithDetails(){
        Books books = new Books();
        BookService bookService = new BookService();

        List<String> testBooks = new ArrayList<String>();
        testBooks.add(HarryPoter);
        testBooks.add(Sea);
        testBooks.add(Sun);
        testBooks.add(ThreeGuns);
        testBooks.add(SamPorts);
        assertEquals(testBooks, bookService.initialBooksWithDetails(books));
    }

    @Test
    public void test_should_delete_book_by_id(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        bookService.deleteBook(books,"Sun");
        List<String> testBooks = new ArrayList<String>();
        List<String> testBooksWithDetails = new ArrayList<String>();
        testBooks.add("HarryPotter");
        testBooks.add("Sea");
        testBooks.add("ThreeGuns");
        testBooks.add("SamPorts");
        testBooksWithDetails.add(HarryPoter);
        testBooksWithDetails.add(Sea);
        testBooksWithDetails.add(ThreeGuns);
        testBooksWithDetails.add(SamPorts);
        assertEquals(testBooks, books.books);
        assertEquals(testBooksWithDetails, books.booksWithDetails);
    }

    @Test
    public void test_should_return_book_by_book_and_bookwithdetails(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        bookService.returnBook(books,"Spo",
                "Spo-------------author:JK------time:2012.12.28------version:1");
        List<String> testBooks = new ArrayList<String>();
        List<String> testBooksWithDetails = new ArrayList<String>();
        testBooks.add("HarryPotter");
        testBooks.add("Sea");
        testBooks.add("Sun");
        testBooks.add("ThreeGuns");
        testBooks.add("SamPorts");
        testBooks.add("Spo");
        testBooksWithDetails.add(HarryPoter);
        testBooksWithDetails.add(Sea);
        testBooksWithDetails.add(Sun);
        testBooksWithDetails.add(ThreeGuns);
        testBooksWithDetails.add(SamPorts);
        testBooksWithDetails.add(Spo);
        assertEquals(testBooks, books.books);
        assertEquals(testBooksWithDetails, books.booksWithDetails);
    }

    @Test
    public void should_delete_book_success(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        assertEquals(bookService.deleteBook(books,"Sun"),"Thank you! Enjoy the book.");
    }
    @Test
    public void should_delete_book_failed(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        assertEquals(bookService.deleteBook(books,"Suo"),"That book is not available.");
    }
    @Test
    public void should_return_success(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        assertEquals(bookService.returnBook(books,"SanSun","suns"), "Thank you for returning the book.");
    }
    @Test
    public void should_return_failed_by_book(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        assertEquals(bookService.returnBook(books,"Sun","suns"), "That is not a valid book to return.");
    }

    @Test
    public void should_return_failed_by_details(){
        Books books = new Books();
        BookService bookService = new BookService();

        bookService.initialBooks(books);
        bookService.initialBooksWithDetails(books);
        assertEquals(bookService.returnBook(books,"tun", Sun), "That is not a valid book to return.");
    }


}
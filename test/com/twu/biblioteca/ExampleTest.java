package com.twu.biblioteca;


import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.WelcomePrintln;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test_Welcome() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        WelcomePrintln welcomePrintln = new WelcomePrintln();
        welcomePrintln.welcome();

        assertEquals("Hello World!\n" +
                "\n" +
                "***********************************\n" +
                "you can have below choices\n" +
                "\n" +
                "\n" +
                "1:look for books\n" +
                "2:look for books with details\n" +
                "3:choose a book you want\n"+
                "4:input your return infos\n"+
                "0:exit system\n", outContent.toString());
    }

    @Test
    public void test_should_show_all_books() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BookStore bookStore = new BookStore();
        bookStore.showBooks(bookStore.initialBooks());

        assertEquals("Harry-Potter\n" +
                "Sea\n" +
                "Sun\n" +
                "Three-guns\n" +
                "Sam-Ports\n", outContent.toString());

    }

    @Test
    public void test_should_show_all_books_with_details() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BookStore bookStore = new BookStore();
        bookStore.showBooks(bookStore.initialBooksWithDetails());

        assertEquals(
                "Harry-Potter-----author:-JK------time:-2012.12.28------version:--1\n" +
                "Sea--------------author:-David---time:-2013.11.12------version:--1\n" +
                "Sun--------------author:-Sam-----time:-2009.02.09------version:--1\n" +
                "Three-guns-------author:-Jan-----time:-2007:01.22------version:--1\n" +
                "Sam-Ports--------author:-Aus-----time:-2015.12.01------version:--1\n", outContent.toString());

    }

    @Test
    public void test_should_return_books(){
        BookStore bookStore = new BookStore();
        List<String> testBooks = new ArrayList<String>();
        testBooks.add("Harry-Potter");
        testBooks.add("Sea");
        testBooks.add("Sun");
        testBooks.add("Three-guns");
        testBooks.add("Sam-Ports");
        assertEquals(testBooks,bookStore.initialBooks());
    }

    @Test
    public void test_should_return_booksWithDetails(){
        BookStore bookStore = new BookStore();
        List<String> testBooks = new ArrayList<String>();
        testBooks.add("Harry-Potter-----author:-JK------time:-2012.12.28------version:--1");
        testBooks.add("Sea--------------author:-David---time:-2013.11.12------version:--1");
        testBooks.add("Sun--------------author:-Sam-----time:-2009.02.09------version:--1");
        testBooks.add("Three-guns-------author:-Jan-----time:-2007:01.22------version:--1");
        testBooks.add("Sam-Ports--------author:-Aus-----time:-2015.12.01------version:--1");
        assertEquals(testBooks,bookStore.initialBooksWithDetails());
    }

    @Test
    public void test_should_delete_book_by_id(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        bookStore.deleteBook("Sun");
        List<String> testBooks = new ArrayList<String>();
        List<String> testBooksWithDetails = new ArrayList<String>();
        testBooks.add("Harry-Potter");
        testBooks.add("Sea");
        testBooks.add("Three-guns");
        testBooks.add("Sam-Ports");
        testBooksWithDetails.add("Harry-Potter-----author:-JK------time:-2012.12.28------version:--1");
        testBooksWithDetails.add("Sea--------------author:-David---time:-2013.11.12------version:--1");
        testBooksWithDetails.add("Three-guns-------author:-Jan-----time:-2007:01.22------version:--1");
        testBooksWithDetails.add("Sam-Ports--------author:-Aus-----time:-2015.12.01------version:--1");
        assertEquals(testBooks,bookStore.books);
        assertEquals(testBooksWithDetails,bookStore.booksWithDetails);
    }

    @Test
    public void test_should_return_book_by_book_and_bookwithdetails(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        bookStore.returnBook("Spo",
                "Spo--------------author:-JK------time:-2012.12.28------version:--1");
        List<String> testBooks = new ArrayList<String>();
        List<String> testBooksWithDetails = new ArrayList<String>();
        testBooks.add("Harry-Potter");
        testBooks.add("Sea");
        testBooks.add("Sun");
        testBooks.add("Three-guns");
        testBooks.add("Sam-Ports");
        testBooks.add("Spo");
        testBooksWithDetails.add("Harry-Potter-----author:-JK------time:-2012.12.28------version:--1");
        testBooksWithDetails.add("Sea--------------author:-David---time:-2013.11.12------version:--1");
        testBooksWithDetails.add("Sun--------------author:-Sam-----time:-2009.02.09------version:--1");
        testBooksWithDetails.add("Three-guns-------author:-Jan-----time:-2007:01.22------version:--1");
        testBooksWithDetails.add("Sam-Ports--------author:-Aus-----time:-2015.12.01------version:--1");
        testBooksWithDetails.add("Spo--------------author:-JK------time:-2012.12.28------version:--1");
        assertEquals(testBooks,bookStore.books);
        assertEquals(testBooksWithDetails,bookStore.booksWithDetails);
    }

    @Test
    public void should_delete_book_success(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        assertEquals(bookStore.deleteBook("Sun"),"Thank you! Enjoy the book.");
    }
    @Test
    public void should_delete_book_failed(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        assertEquals(bookStore.deleteBook("Suo"),"That book is not available.");
    }
    @Test
    public void should_return_success(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        assertEquals(bookStore.returnBook("SanSun","suns"),
                "Thank you for returning the book.");
    }
    @Test
    public void should_return_failed_by_book(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        assertEquals(bookStore.returnBook("Sun","suns"),
                "That is not a valid book to return.");
    }

    @Test
    public void should_return_failed_by_details(){
        BookStore bookStore = new BookStore();
        bookStore.initialBooks();
        bookStore.initialBooksWithDetails();
        assertEquals(bookStore.returnBook("tun",
                "Sun--------------author:-Sam-----time:-2009.02.09------version:--1"),
                "That is not a valid book to return.");
    }

}

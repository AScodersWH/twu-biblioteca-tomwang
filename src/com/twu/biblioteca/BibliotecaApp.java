package com.twu.biblioteca;

import com.twu.biblioteca.service.BookStore;
import com.twu.biblioteca.service.WelcomePrintln;

import java.util.List;
import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomePrintln welcomePrintln = new WelcomePrintln();
        welcomePrintln.welcome();
        BookStore bookStore = new BookStore();
        List<String> booksWithDetail = bookStore.initialBooksWithDetails();
        List<String> book = bookStore.initialBooks();


        int status = 1;
        while (status == 1) {
            Scanner scanner = new Scanner(System.in);
            int command = Integer.valueOf(scanner.next());
            if (command==1) {

                System.out.println("\nhere are all books");
                System.out.println("\n*************************\n");
                bookStore.showBooks(book);
                System.out.println("\n*************************\n");

                welcomePrintln.welcome();
            }
            if (command==2) {
                System.out.println("\nhere are all books with details\n");
                System.out.println("\n*************************\n");
                bookStore.showBooks(booksWithDetail);
                System.out.println("\n*************************\n");

                welcomePrintln.welcome();
            }


            if (command==3) {
                System.out.println("\n**********************************\n" +
                        "please input the book you want : ");
                String bookToLend = new Scanner(System.in).next();

                System.out.println(bookStore.deleteBook(bookToLend));
                System.out.println("\n*************************\n");
                welcomePrintln.welcome();
            }

            if (command==4) {
                System.out.println("\n**********************************\n" +
                        "please input the book you want to return : ");
                String bookToReturn = new Scanner(System.in).next();
                System.out.println("\n**********************************\n" +
                        "please input the book with details you want to return : ");
                String bookWithDetailsToReturn = new Scanner(System.in).next();
                System.out.println(bookStore.returnBook(bookToReturn, bookWithDetailsToReturn));
                System.out.println("\n*************************\n");
                welcomePrintln.welcome();
            }

            if (command==0) {
                System.out.println("\nThanks for use our system\n" +
                        "**********************************");
                status = 0;
            }

                if(command>4){
                System.out.println("\nplease choose others!");
                System.out.println("\n*************************\n");
                welcomePrintln.welcome();

            }

        }
    }
}

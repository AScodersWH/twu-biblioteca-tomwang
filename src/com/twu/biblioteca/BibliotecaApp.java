package com.twu.biblioteca;

import com.twu.biblioteca.model.Books;
import com.twu.biblioteca.model.Movies;
import com.twu.biblioteca.model.Users;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.service.WelcomePrintln;

import java.util.List;
import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) {
        Users users = new Users();
        UserService userService = new UserService();

        System.out.println("Hello World!");
        System.out.println("Please login");
        System.out.println("Please input your username : ");
        String userName = new Scanner(System.in).next();
        System.out.println("Please input your password : ");
        String passWord = new Scanner(System.in).next();
        int status = userService.login(users,userName,passWord);
        if(status==0){
            System.out.println("sorry you are not our users,please contact manager");
            return;
        }

        WelcomePrintln welcomePrintln = new WelcomePrintln();
        welcomePrintln.welcome();
        Books books = new Books();
        BookService bookService = new BookService();
        List<String> booksWithDetail = bookService.initialBooksWithDetails(books);
        List<String> book = bookService.initialBooks(books);

        Movies movies = new Movies();
        MovieService movieService = new MovieService();
        movieService.initialMoviesWithDetails(movies);
        while (status == 1) {
            Scanner scanner = new Scanner(System.in);
            int command = Integer.valueOf(scanner.next());
            if (command==1) {

                System.out.println("\nhere are all books");
                System.out.println("\n*************************\n");
                bookService.showBooks(book);
                System.out.println("\n*************************\n");

                welcomePrintln.welcome();
            }
            if (command==2) {
                System.out.println("\nhere are all books with details\n");
                System.out.println("\n*************************\n");
                bookService.showBooks(booksWithDetail);
                System.out.println("\n*************************\n");

                welcomePrintln.welcome();
            }


            if (command==3) {
                System.out.println("\n**********************************\n" +
                        "please input the book you want : ");
                String bookToLend = new Scanner(System.in).next();

                System.out.println(bookService.deleteBook(books,bookToLend));
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
                System.out.println(bookService.returnBook(books,bookToReturn, bookWithDetailsToReturn));
                System.out.println("\n*************************\n");
                welcomePrintln.welcome();
            }

            if(command==5){
                System.out.println("\nhere are all movies with details\n");
                System.out.println("\n*************************\n");
                movieService.showBooks(movies.moviesWithDetails);
                System.out.println("\n*************************\n");

                welcomePrintln.welcome();

            }
            if(command==6){
                System.out.println("\n**********************************\n" +
                        "please input the movie with details you want : ");
                String movie = new Scanner(System.in).next();

                System.out.println(movieService.checkoutMovie(movies,movie));
                System.out.println("\n*************************\n");
                welcomePrintln.welcome();
            }

            if (command==0) {
                System.out.println("\nThanks for use our system\n" +
                        "**********************************");
                status = 0;
            }

                if(command>6){
                System.out.println("\nplease choose others!");
                System.out.println("\n*************************\n");
                welcomePrintln.welcome();

            }

        }
    }
}

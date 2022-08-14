package by.grovs.controller;

import by.grovs._3_service.impl.BookServiceImpl;
import by.grovs._5_dao.impl.BookDaoImpl;

import by.grovs._4_entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Console {

    public void start() {
        BookDaoImpl dao = BookDaoImpl.getInstance();
        BookServiceImpl service = BookServiceImpl.getInstance();

        String command = "all - show list of all books \n" +
                "get {id} - show book by id \n" +
                "add - add new book \n" +
                "edit {id} - edit book by id \n" +
                "delete {id} - delete book by id \n" +
                "get by isbn {isbn} - show book by isbn \n" +
                "get books by author {author} - show books by author\n" +
                "count - count all books\n" +
                "exit - exit \n" +
                "help - show list of command \n";

        System.out.println("Welcome to my awesome book store!" + "\n");

        System.out.println("Please choose what you need: \n" + command + "\n");

        try {
            while (true) {

                Scanner in = new Scanner(System.in);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("\nInput a command: \n");

                switch (bufferedReader.readLine()) {

                    case "all":
                        print(dao.getBooks());
                        break;

                    case "get":
                        System.out.println("\nInput id of book:");
                        printOne(service.getById(in.nextLong()));
                        break;

                    case "add":
                        System.out.println("\nInput title of book:");

                        String title = bufferedReader.readLine();

                        System.out.println("\nInput author of book:");

                        String author = bufferedReader.readLine();

                        printOne(dao.addBook(new Book(title, author)));
                        break;

                    case "edit":
                        System.out.println("\nInput id of book:");

                        long id = in.nextLong();

                        System.out.println("\nInput title of book:");

                        String name = bufferedReader.readLine();

                        System.out.println("\nInput author of book:");
                        String creator = bufferedReader.readLine();

                        Book book = new Book(id, name, creator);
                        printOne(dao.update(book));
                        break;

                    case "delete":
                        System.out.println("\nInput id of book:");
                        long id1 = in.nextLong();
                        boolean delete = dao.delete(id1);
                        if (delete) System.out.println("Delete is done!");
                        break;

                    case "get by isbn":
                        System.out.println("\nInput isbn of book:");

                        String isbn = bufferedReader.readLine();

                        printOne(dao.getByIsbn(isbn));
                        break;

                    case "get books by author":
                        System.out.println("\nInput author of book:");

                        String authorBook = bufferedReader.readLine();

                        print(dao.getBooksByAuthor(authorBook));
                        break;

                    case "count":
                        System.out.println(dao.countAllBooks());
                        break;

                    case "help":
                        System.out.println(command);
                        break;

                    case "exit":
                        System.out.println("Thanks for visiting!!!!!!");
                        return;

                    case "fill isbn":
                        dao.fillIsbn();
                        System.out.println("The column isbn was fill!");
                        break;

                    case "fill date":
                        dao.fillDate();
                        System.out.println("The column date was fill!");
                        break;

                    case "fill cost":
                        dao.fillCost();
                        System.out.println("The column cost was fill!");
                        break;
                    case "1":
                        System.out.println(service.calcTotalCostByAuthor("Leo Tolstoy"));
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void printOne(Book book) {

        System.out.printf("%-4s %-20s %-15s %-15s %n", "id", "title", "author", "isbn");
        System.out.printf("%-4s %-20s %-15s %-15s %n", "__", "_______", "_______", "_______");

        System.out.printf("%-4d %-20s %-15s %-15s%n",
                book.getId(), book.getName(), book.getAuthor(), book.getIsbn());

    }

    void print(List<Book> books) {

        System.out.printf("%-4s %-15s %-15s %n", "id", "title", "author");
        System.out.printf("%-4s %-15s %-15s %n", "__", "_______", "_______");

        for (Book book : books) {
            System.out.printf("%-4d %-15s %-15s%n", book.getId(), book.getName(), book.getAuthor());
        }

    }
}

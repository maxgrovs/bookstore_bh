package by.grovs.view;

import by.grovs.dao.BookDaoImpl;

import by.grovs.model.Book;
import by.grovs.utils.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class Console {

    public void start() {

        String command = "1 - show list of all books \n" +
                "2 - show book by id \n" +
                "3 - add new book \n" +
                "4 - edit book by id \n" +
                "5 - delete book by id \n" +
                "6 - show book by isbn \n" +
                "7 - show books by author\n" +
                "8 - count all books\n" +
                "-1 - exit \n" +
                "0 - show list of command \n";

        System.out.println("Welcome to my awesome book store!" + "\n");

        System.out.println("Please choose what you need: \n" + command);

        System.out.println();

        while (true) {

            BookDaoImpl dao = new BookDaoImpl(new DataSource());

            Reader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Scanner in = new Scanner(System.in);
            System.out.print("\nInput a command: \n");

            int num = in.nextInt();


            switch (num) {
                case 1:
                    print(dao.getAllBooks());
                    break;
                case 2:
                    System.out.println("\nInput id of book:");
                    printOne(dao.getById(in.nextLong()));

                    break;
                case 3:
                    String title = null;
                    String author = null;

                    System.out.println("\nInput title of book:");

                    try {
                        title = bufferedReader.readLine();

                        System.out.println("\nInput author of book:");
                        author = bufferedReader.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    printOne(dao.addBook(title, author));

                    break;
                case 4:
                    System.out.println("\nInput id of book:");

                    String name = null;
                    String creator = null;

                    long id = in.nextLong();

                    System.out.println("\nInput title of book:");

                    try {
                        name = bufferedReader.readLine();

                        System.out.println("\nInput author of book:");
                        creator = bufferedReader.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    printOne(dao.update(new Book(id, name, creator)));


                    break;
                case 5:
                    System.out.println("\nInput id of book:");
                    long id1 = in.nextLong();
                    boolean delete = dao.delete(id1);
                    if (delete) System.out.println("Delete is done!");
                    break;

                case 6:
                    String isbn = null;
                    System.out.println("\nInput isbn of book:");

                    try {
                        isbn = bufferedReader.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    printOne(dao.getByIsbn(isbn));

                    break;
                case 7:
                    System.out.println("\nInput author of book:");

                    String authorBook = null;
                    try {
                        authorBook = bufferedReader.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    print(dao.getBooksByAuthor(authorBook));

                case 8:
                    System.out.println(dao.countAllBooks());
                    break;

                case 0:
                    System.out.println(command);
                    break;

                case -1:
                    System.out.println("Thanks for visiting!!!!!!");
                    return;

                case -2:
                    dao.fillIsbn();
                    System.out.println("The column isbn was fill!");
                    break;

            }
        }
    }

    void printOne(Book book) {

        System.out.printf("%-4s %-15s %-15s %-15s %n", "id", "title", "author", "isbn");
        System.out.printf("%-4s %-15s %-15s %-15s %n", "__", "_______", "_______", "_______");

        System.out.printf("%-4d %-15s %-15s %-15s%n",
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

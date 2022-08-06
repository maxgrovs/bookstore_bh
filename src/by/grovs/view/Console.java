package by.grovs.view;

import by.grovs.dao.BookDaoImpl;

import by.grovs.model.Book;
import by.grovs.utils.DataSource;
import by.grovs.utils.Util;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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
                "7 - show books by author" +
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
                    dao.getAllBooks();
                    break;
                case 2:
                    System.out.println("\nInput id of book:");
                    dao.getById(in.nextLong());
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

                    dao.addBook(title, author);
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

                    dao.update(new Book(id, name, creator));

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

                    dao.getByIsbn(isbn);
                    break;
                case 7:
                    System.out.println("\nInput author of book:");

                    String authorBook = null;
                    try {
                        authorBook = bufferedReader.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    dao.getBooksByAuthor(authorBook);


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
}

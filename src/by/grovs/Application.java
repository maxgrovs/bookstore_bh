package by.grovs;

import by.grovs.dao.BookDaoImpl;
import by.grovs.model.Book;
import by.grovs.utils.DataSource;

import java.sql.SQLException;

public class Application {


    public static void main(String[] args) throws SQLException {

        BookDaoImpl dao = new BookDaoImpl(new DataSource());
      //  List<Book> books = dao.getBooks();

//        Book byId = dao.getById(4L);
//        System.out.println(byId.toString());

        Book book = dao.addBook("Anna Karenin-6", "Leo Tolstoy-6");
        System.out.println(book);
        //   List<Book> books = getBooks();

      //  books.forEach(System.out::println);

    }


}

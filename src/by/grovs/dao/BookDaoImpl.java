package by.grovs.dao;

import by.grovs.model.Book;
import by.grovs.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl {

    public static final String FIND_ONE = "SELECT id, name, author FROM books WHERE id = ?";
    public static final String FIND_ALL = "SELECT id, name, author FROM books";
    private final DataSource dataSource;

    public BookDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //CRUD
    //create
    public Book addBook(String name, String author) {
        long id = -1L;
        Book book = new Book();

        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (name, author)" +
                    "VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, author);

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);

                book.setId(generatedKeys.getLong("id"));
                book.setName(generatedKeys.getString("name"));
                book.setAuthor(generatedKeys.getString("author"));

            }
            System.out.println(id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;

    }

    //read all
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {

                Book book = new Book();

                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));

                books.add(book);
                // System.out.printf("Book: id=%d, name=%s, author=%s%n", id, name, author);
            }
            System.out.println("List finished!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    public Book getById(Long id) {
        Book book = new Book();
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));

                // System.out.printf("Book: id=%d, name=%s, author=%s%n", id, name, author);
            }
            System.out.println("List finished!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }


    //update
    Book update(Book book) {

        return book;
    }

    ;

    //delete
    boolean delete(Long id) {

        return false;
    }

    ;
}

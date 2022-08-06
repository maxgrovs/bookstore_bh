package by.grovs.dao;

import by.grovs.model.Book;
import by.grovs.utils.DataSource;
import by.grovs.utils.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl {

    public static final String FIND_ONE = "SELECT id, name, author, isbn FROM books WHERE id = ?";
    public static final String FIND_ALL = "SELECT id, name, author, isbn FROM books";
    private final DataSource dataSource;

    public BookDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //CRUD
    //create
    public Book addBook(String name, String author) {

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

                book.setId(generatedKeys.getLong("id"));
                book.setName(generatedKeys.getString("name"));
                book.setAuthor(generatedKeys.getString("author"));
               // book.setIsbn(generatedKeys.getString("isbn"));

                System.out.printf("%-4s %-15s %-15s %n", "id", "title", "author");
                System.out.printf("%-4s %-15s %-15s %n", "__", "_______", "_______");

                System.out.printf("%-4d %-15s %-15s%n",
                        book.getId(), book.getName(), book.getAuthor());

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;

    }

    //read all
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            System.out.printf("%-4s %-15s %-15s %n", "id", "title", "author");
            System.out.printf("%-4s %-15s %-15s %n", "__", "_______", "_______");


            while (resultSet.next()) {

                Book book = new Book();

                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                //book.setIsbn(resultSet.getString());

                books.add(book);

                System.out.printf("%-4d %-15s %-15s%n",
                        book.getId(), book.getName(), book.getAuthor());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }


    //Read one
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
                book.setIsbn(resultSet.getString("isbn"));

                System.out.printf("%-4s %-15s %-15s %-15s %n", "id", "title", "author", "isbn");
                System.out.printf("%-4s %-15s %-15s %-15s %n", "__", "_______", "_______", "_______");

                System.out.printf("%-4d %-15s %-15s %-15s%n",
                        book.getId(), book.getName(), book.getAuthor(), book.getIsbn());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }


    //update

    public Book update(Book book) {

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                if (id == book.getId()) {
                    resultSet.updateString("name", book.getName());
                    resultSet.updateString("author", book.getAuthor());
                    resultSet.updateRow();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    //delete
    public boolean delete(Long id) {
        boolean result = false;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                long currentId = resultSet.getLong(1);
                if (currentId == id) {
                    resultSet.deleteRow();
                    result = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //fill isbn
    public void fillIsbn() {
        try {
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");

                if (isbn == null) {
                    resultSet.updateString("isbn", new Util().getIsbn());
                    resultSet.updateRow();
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

package by.grovs.dao;

import by.grovs.model.Book;
import by.grovs.utils.DataSource;
import by.grovs.utils.Util;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl {

    public static final String FIND_ONE = "SELECT id, name, author, isbn FROM books WHERE id = ?";
    public static final String FIND_ONE_BY_ISBN = "SELECT id, name, author, isbn FROM books WHERE isbn = ?";
    public static final String FIND_ALL_BY_AUTHOR = "SELECT * FROM books WHERE author = ?";
    public static final String FIND_ALL = "SELECT id, name, author, isbn, data date FROM books";
    private final DataSource dataSource;

    public BookDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //CRUD
    //_________________________________________________

    //create
    public Book addBook(String name, String author) {

        Book book = new Book();

        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO books (name, author, isbn)" +
                            "VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            String isbn = new Util().getIsbn();

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, isbn);

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {

                book.setId(generatedKeys.getLong("id"));
                book.setName(generatedKeys.getString("name"));
                book.setAuthor(generatedKeys.getString("author"));
                book.setIsbn(generatedKeys.getString("isbn"));

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

            while (resultSet.next()) {

                Book book = new Book();

                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDateOfPublication((resultSet.getDate("date")).toLocalDate());

                books.add(book);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {

        List<Book> books = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_AUTHOR);
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();

                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));

                books.add(book);

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

    public Book getByIsbn(String isbn) {
        Book book = new Book();
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE_BY_ISBN);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
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

    //fill date
    public void fillDate() {
        try {
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                String date = resultSet.getString("date");

                LocalDate randomDateOfPublication = new Util().getRandomDateOfPublication();

                if (date == null) {
                    resultSet.updateDate("date", Date.valueOf(randomDateOfPublication));
                    resultSet.updateRow();
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

}

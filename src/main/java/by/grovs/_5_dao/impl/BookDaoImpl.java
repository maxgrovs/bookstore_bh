package by.grovs._5_dao.impl;

import by.grovs._4_entity.Book;
import by.grovs._3_service.Util;
import by.grovs._5_dao.BookDao;
import by.grovs.util.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private static final Logger log = LogManager.getLogger(BookDao.class);

    private static final BookDaoImpl INSTANCE = new BookDaoImpl();

    public static BookDaoImpl getInstance() {
        return INSTANCE;
    }

    Connection connection;

    private BookDaoImpl() {
        try {
            connection = ConnectionManager.get();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static final String ADD_BOOK = "INSERT INTO books (name, author, isbn, date )" +
            "VALUES (?, ?, ?, ?)";
    public static final String FIND_ALL = "SELECT * FROM books";
    public static final String FIND_ONE = "SELECT id, name, author, isbn, date, cost FROM books WHERE id = ?";
    public static final String FIND_ONE_BY_ISBN = "SELECT * FROM books WHERE isbn = ?";
    public static final String FIND_ALL_BY_AUTHOR = "SELECT * FROM books WHERE author = ?";

    private final Util util = Util.getInstance();


    //CRUD
    //_________________________________________________

    //create
    public Book addBook(Book book) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    ADD_BOOK, PreparedStatement.RETURN_GENERATED_KEYS);

            String isbn = util.getIsbn();
            LocalDate date = util.getRandomDateOfPublication();

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, isbn);
            preparedStatement.setDate(4, Date.valueOf(date));

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {

                getBook(generatedKeys);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }

    //read all
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        try {
            ResultSet resultSet = getResultSet(FIND_ALL);

            while (resultSet.next()) {

                books.add(getBook(resultSet));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {

        List<Book> books = new ArrayList<>();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_AUTHOR);
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Book book = getBook(resultSet);

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

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                book = getBook(resultSet);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }

    //update

    public Book update(Book book) {

        try {
            ResultSet resultSet = getResultSet(FIND_ALL);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                if (id == book.getId()) {
                    resultSet.updateString("name", book.getName());
                    resultSet.updateString("author", book.getAuthor());

                    resultSet.updateRow();

                    book.setIsbn(resultSet.getString("isbn"));
                    book.setDate((resultSet.getDate("date")).toLocalDate());

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
            ResultSet resultSet = getResultSet(FIND_ALL);

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

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE_BY_ISBN);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                book = getBook(resultSet);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }

    //fill isbn
    public void fillIsbn() {
        try {
            ResultSet resultSet = getResultSet(FIND_ALL);

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");

                if (isbn == null) {
                    resultSet.updateString("isbn", util.getIsbn());
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
            ResultSet resultSet = getResultSet(FIND_ALL);

            while (resultSet.next()) {
                String date = resultSet.getString("date");

                LocalDate randomDateOfPublication = util.getRandomDateOfPublication();

                if (date == null) {
                    resultSet.updateDate("date", Date.valueOf(randomDateOfPublication));
                    resultSet.updateRow();
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //fill cost
    public void fillCost() {

        try {
            ResultSet resultSet = getResultSet(FIND_ALL);

            while (resultSet.next()) {

                BigDecimal cost = resultSet.getBigDecimal("cost");

                BigDecimal randomCost = util.getRandomCost(
                        new BigDecimal("5.0"), new BigDecimal("1000.0"));

                if (cost == null) {
                    resultSet.updateBigDecimal("cost", randomCost);
                    resultSet.updateRow();
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public long countAllBooks() {
        return getBooks().size();
    }


    private ResultSet getResultSet(String sql) {

        ResultSet resultSet = null;

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    private Book getBook(ResultSet resultSet) {
        Book book = new Book();
        try {
            book.setId(resultSet.getLong("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setDate((resultSet.getDate("date")).toLocalDate());
            book.setCost(resultSet.getBigDecimal("cost"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

}

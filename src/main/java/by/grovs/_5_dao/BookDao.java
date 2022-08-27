package by.grovs._5_dao;

import by.grovs._4_entity.Book;

import java.util.List;

public interface BookDao {

    //CRUD
    //create
    Book addBook(Book book);

    //read
    List<Book> getBooks();

    Book getById(Long id);

    //update
    Book update(Book book);

    //delete
    boolean delete(Long id);
}

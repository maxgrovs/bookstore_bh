package by.grovs.dao;

import by.grovs.model.Book;

import java.util.List;

public interface BookDao {

    //CRUD
    //create
    Book addBook(String name, String author);

    //read
    List<Book> getBooks();

    Book getById(Long id);

    //update
    Book update(Book book);

    //delete
    boolean delete(Long id);
}

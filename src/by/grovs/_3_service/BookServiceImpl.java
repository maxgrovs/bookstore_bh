package by.grovs._3_service;

import by.grovs._4_entity.Book;
import by.grovs._5_dao.BookDao;
import by.grovs._5_dao.BookDaoImpl;
import by.grovs._5_dao.DataSource;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao dao = new BookDaoImpl(new DataSource());





    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public List<Book> getAll() {
        return dao.getBooks();
    }

    @Override
    public Book getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public Book editBook(Book book) {
        return dao.update(book);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

}

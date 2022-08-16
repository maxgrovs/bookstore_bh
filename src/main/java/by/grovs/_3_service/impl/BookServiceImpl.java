package by.grovs._3_service.impl;

import by.grovs._3_service.BookService;
import by.grovs._4_entity.Book;
import by.grovs._5_dao.BookDao;
import by.grovs._5_dao.impl.BookDaoImpl;
import by.grovs._5_dao.connect.DataSource;
import java.math.BigDecimal;
import java.util.List;


public class BookServiceImpl implements BookService {



    private final BookDao dao = new BookDaoImpl(new DataSource());

    public BigDecimal calcTotalCostByAuthor(String author) {

        return getAll().stream()
                .filter(o -> o.getAuthor().equals(author))
                .map(o -> o.getCost())
                .reduce((a, b) -> a.add(b))
                .get();
    }

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

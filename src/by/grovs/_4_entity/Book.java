package by.grovs._4_entity;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private long id;
    private String name;
    private String author;
    private String isbn;

    private LocalDate dateOfPublication;

    public Book() {
    }

    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(long id, String name, String author, String isbn, LocalDate dateOfPublication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.dateOfPublication = dateOfPublication;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(dateOfPublication, book.dateOfPublication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, isbn, dateOfPublication);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                '}';
    }
}

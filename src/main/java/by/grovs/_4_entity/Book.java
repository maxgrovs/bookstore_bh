package by.grovs._4_entity;

import by.grovs._2_dto.BookDto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Book {

    private long id;
    private String name;
    private String author;
    private String isbn;
    private BigDecimal cost;

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

    public Book(long id, String name, String author, String isbn, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.cost = cost;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }


    public static Book.Builder builder() {
        return new Book.Builder();
    }

    public static class Builder {

        private long id;
        private String name;
        private String author;
        private String isbn;
        private BigDecimal cost;

        public Book.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Book.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Book.Builder author(String author) {
            this.author = author;
            return this;
        }

        public Book.Builder cost(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Book.Builder isbn(BigDecimal cost) {
            this.cost = cost;
            return this;
        }


        public Book build() {

            return
                    new Book(
                            this.id,
                            this.name,
                            this.author,
                            this.isbn,
                            this.cost
                    );
        }


    }
}

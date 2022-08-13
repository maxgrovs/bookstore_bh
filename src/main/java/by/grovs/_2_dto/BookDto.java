package by.grovs._2_dto;
import java.math.BigDecimal;

//builder

public class BookDto {

    private long id;
    private String name;
    private String author;
    private String isbn;
    private BigDecimal cost;

    public BookDto() {
    }

    public BookDto(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public BookDto(String name, String author, String isbn, BigDecimal cost) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.cost = cost;
    }

    public BookDto(long id, String name, String author, String isbn, BigDecimal cost) {
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


    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", cost=" + cost +
                '}';
    }


    public static BookDto.Builder builder() {
        return new BookDto.Builder();
    }

    public static class Builder {

        private long id;
        private String name;
        private String author;
        private String isbn;
        private BigDecimal cost;

        public BookDto.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public BookDto.Builder name(String name) {
            this.name = name;
            return this;
        }

        public BookDto.Builder author(String author) {
            this.author = author;
            return this;
        }

        public BookDto.Builder cost(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookDto.Builder isbn(BigDecimal cost) {
            this.cost = cost;
            return this;
        }


        public BookDto build() {

            return
                    new BookDto(
                            this.id,
                            this.name,
                            this.author,
                            this.isbn,
                            this.cost
                    );
        }
    }

}

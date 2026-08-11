package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private Date publishDate;
    private BigDecimal price;
    private String isbn;
    private int quantity;

    public Book(){

    }

    public Book(int bookId, String title, String author, String publisher, Date publishDate, BigDecimal price, String isbn, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public Book(String title, String author, String publisher, Date publishDate, BigDecimal price, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public int getBookId(){
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Book {

    private int bookId;
    private String title;
    private int authorId;
    private String authorName;
    private String publisher;
    private Date publishDate;
    private BigDecimal price;
    private String isbn;
    private int quantity;

    // 1. Constructor rỗng
    public Book(){

    }

    // 2. Có bookId (dùng cho SELECT)
    public Book(int bookId, String title, int authorId, String publisher, Date publishDate, BigDecimal price, String isbn, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // 3. Không có bookId (dùng cho INSERT)
    public Book(String title, int authorId, String publisher, Date publishDate, BigDecimal price, String isbn, int quantity){
        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // 4. Dùng cho JOIN
    public Book(int bookId, String title, int authorId, String authorName, String publisher, Date publishDate, BigDecimal price, String isbn, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.authorName = authorName;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}


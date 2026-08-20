package dao;

import model.Book;
import util.DBConnection;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public boolean addBook(Book book){

        String sql = "INSERT INTO books(title, author_id, publisher, publish_date, price, isbn, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getAuthorId());
            ps.setString(3, book.getPublisher());
            ps.setDate(4, book.getPublishDate());
            ps.setBigDecimal(5, book.getPrice());
            ps.setString(6, book.getIsbn());
            ps.setInt(7, book.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0){
                return true;
            }

            return false;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public List<Book> showAllBooks(){

        List<Book> books = new ArrayList<>();

        String sql = """
                        SELECT 
                            b.book_id,
                            b.title, 
                            b.author_id,
                            a.author_name AS author,
                            b.publisher, 
                            b.publish_date, 
                            b.price, 
                            b.isbn, 
                            b.quantity
                        FROM books b 
                        JOIN authors a
                            ON b.author_id = a.author_id
                        """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public Book findBookById(int id){

        String sql = "SELECT * FROM books " +
                "WHERE book_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

             if (rs.next()){

                 Book book = new Book(
                         rs.getInt("book_id"),
                         rs.getString("title"),
                         rs.getInt("author_id"),
                         rs.getString("publisher"),
                         rs.getDate("publish_date"),
                         rs.getBigDecimal("price"),
                         rs.getString("isbn"),
                         rs.getInt("quantity")
                 );

                 return book;

             }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return null;

    }

    public List<Book> searchBooksByTitle(String keyword){

        List<Book> books = new ArrayList<>();

        String sql = """
                SELECT 
                    b.book_id,
                    b.title, 
                    b.author_id,
                    a.author_name AS author,
                    b.publisher, 
                    b.publish_date, 
                    b.price, 
                    b.isbn, 
                    b.quantity
                FROM books b 
                JOIN authors a 
                    ON b.author_id = a.author_id
                WHERE b.title ILIKE ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public List<Book> searchBooksByAuthor(String keyword){

        List<Book> books = new ArrayList<>();

        String sql = """
                SELECT 
                    b.book_id,
                    b.title, 
                    b.author_id,
                    a.author_name AS author,
                    b.publisher, 
                    b.publish_date, 
                    b.price, 
                    b.isbn, 
                    b.quantity
                FROM books b 
                JOIN authors a 
                    ON b.author_id = a.author_id
                WHERE a.author_name ILIKE ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public List<Book> searchBooksByIsbn(String keyword){

        List<Book> books = new ArrayList<>();

        String sql = """
                SELECT 
                    b.book_id,
                    b.title, 
                    b.author_id,
                    a.author_name AS author,
                    b.publisher, 
                    b.publish_date, 
                    b.price, 
                    b.isbn, 
                    b.quantity
                FROM books b 
                JOIN authors a 
                    ON b.author_id = a.author_id
                WHERE b.isbn ILIKE ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public List<Book> sortBooksByPrice(boolean ascending){

        List<Book> books = new ArrayList<>();

        String order = ascending ? "ASC" : "DESC";

        String sql = """
                 SELECT
                    b.book_id,
                    b.title, 
                    b.author_id,
                    a.author_name AS author,
                    b.publisher, 
                    b.publish_date, 
                    b.price, 
                    b.isbn, 
                    b.quantity
                FROM books b 
                JOIN authors a 
                    ON b.author_id = a.author_id
                ORDER BY b.price
                """ + order;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public List<Book> sortBooksByPublishDate(boolean ascending){

        List<Book> books = new ArrayList<>();

        String order = ascending ? "ASC" : "DESC";

        String sql = """
                SELECT 
                    b.book_id,
                    b.title, 
                    b.author_id,
                    a.author_name AS author,
                    b.publisher, 
                    b.publish_date, 
                    b.price, 
                    b.isbn, 
                    b.quantity
                FROM books b 
                JOIN authors a 
                    ON b.author_id = a.author_id
                ORDER BY b.publish_date 
                """ + order;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public List<Book> filterBooksByPrice(BigDecimal minPrice, BigDecimal maxPrice){

        List<Book> books = new ArrayList<>();

        String sql = """
                SELECT
                    b.book_id,
                    b.title, 
                    b.author_id,
                    a.author_name AS author,
                    b.publisher, 
                    b.publish_date, 
                    b.price, 
                    b.isbn, 
                    b.quantity
                FROM books b 
                JOIN authors a
                    ON b.author_id = a.author_id
                WHERE b.price BETWEEN ? AND ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setBigDecimal(1, minPrice);
            ps.setBigDecimal(2, maxPrice);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getInt("author_id"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getDate("publish_date"),
                        rs.getBigDecimal("price"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                );

                books.add(book);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return books;

    }

    public boolean updateBook(Book book){

        String sql = "UPDATE books " +
                "SET title = ?, author_id = ?, publisher = ?, publish_date = ?, price = ?, isbn = ?, quantity = ? " +
                "WHERE book_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getAuthorId());
            ps.setString(3, book.getPublisher());
            ps.setDate(4, book.getPublishDate());
            ps.setBigDecimal(5, book.getPrice());
            ps.setString(6, book.getIsbn());
            ps.setInt(7, book.getQuantity());
            ps.setInt(8, book.getBookId());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public boolean deleteBook(int id){

        String sql = "DELETE FROM books " +
                "WHERE book_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

}

package dao;

import model.Author;
import util.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    public boolean addAuthor(Author author){

        String sql = "INSERT INTO authors(author_name, country, birth_date) " +
                "VALUES (?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, author.getAuthorName());
            ps.setString(2, author.getCountry());
            ps.setDate(3, author.getBirthDate());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public List<Author> showAllAuthors(){

        List<Author> authors = new ArrayList<>();

        String sql = "SELECT * FROM authors";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Author author = new Author(
                        rs.getInt("author_id"),
                        rs.getString("author_name"),
                        rs.getString("country"),
                        rs.getDate("birth_date")
                );

                authors.add(author);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return authors;

    }

    public Author findAuthorById(int id){

        String sql = "SELECT * FROM authors " +
                "WHERE author_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                Author author = new Author(
                        rs.getInt("author_id"),
                        rs.getString("author_name"),
                        rs.getString("country"),
                        rs.getDate("birth_date")
                );

                return author;

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return null;

    }

    public boolean updateAuthor(Author author){

        String sql = "UPDATE authors " +
                "SET author_name = ?, country = ?, birth_date = ? " +
                "WHERE author_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, author.getAuthorName());
            ps.setString(2, author.getCountry());
            ps.setDate(3, author.getBirthDate());
            ps.setInt(4, author.getAuthorId());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public boolean deleteAuthor(int id){

        String sql = "DELETE FROM authors " +
                "WHERE author_id = ?";

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

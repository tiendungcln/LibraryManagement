package dao;

import model.Borrow;
import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {

    public boolean addBorrow(Borrow borrow){

        String sql = "INSERT INTO borrows(member_id, book_id) " +
                "VALUES(?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setInt(1, borrow.getMemberId());
            ps.setInt(2, borrow.getBookId());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public List<Borrow> showAllBorrows(){

        List<Borrow> borrows = new ArrayList<>();

        String sql = """
                SELECT 
                    br.borrow_id,
                    br.member_id,
                    m.name AS member_name,
                    br.book_id,
                    b.title AS book_name,
                    br.borrow_date,
                    br.return_date
                FROM borrows br 
                JOIN members m
                    ON br.member_id = m.member_id
                JOIN books b
                    ON br.book_id = b.book_id
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Borrow borrow = new Borrow(
                        rs.getInt("borrow_id"),
                        rs.getInt("member_id"),
                        rs.getString("member_name"),
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getDate("borrow_date"),
                        rs.getDate("return_date")
                );

                borrows.add(borrow);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return borrows;

    }

    public Borrow findBorrowById(int id){

        String sql = """
                SELECT 
                    br.borrow_id,
                    br.member_id,
                    m.name AS member_name,
                    br.book_id,
                    b.title AS book_name,
                    br.borrow_date,
                    br.return_date
                FROM borrows br 
                JOIN members m
                    ON br.member_id = m.member_id
                JOIN books b
                    ON br.book_id = b.book_id
                WHERE borrow_id = ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                Borrow borrow = new Borrow(
                        rs.getInt("borrow_id"),
                        rs.getInt("member_id"),
                        rs.getString("member_name"),
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getDate("borrow_date"),
                        rs.getDate("return_date")
                );

                return borrow;

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return null;

    }

}

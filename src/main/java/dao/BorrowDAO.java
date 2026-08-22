package dao;

import model.Borrow;
import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}

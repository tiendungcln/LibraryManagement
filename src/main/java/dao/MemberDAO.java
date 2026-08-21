package dao;

import model.Member;
import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

    public boolean addMember(Member member){

        String sql = "INSERT INTO members(name, email, phone) " +
                "VALUES (?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

}

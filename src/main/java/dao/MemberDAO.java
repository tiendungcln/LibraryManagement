package dao;

import model.Member;
import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Member> showAllMembers(){

        List<Member> members = new ArrayList<>();

        String sql = "SELECT * FROM members";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Member member = new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("join_date")
                );

                members.add(member);

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return members;

    }

    public Member findMemberById(int id){

        String sql = "SELECT * FROM members " +
                "WHERE member_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Member member = new Member(
                        rs.getInt("member_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("join_date")
                );

                return member;

            }

        }catch (SQLException | IOException e){

            e.printStackTrace();

        }

        return null;

    }

    public boolean updateMember(Member member){

        String sql = "UPDATE members " +
                "SET name = ?, email = ?, phone = ? " +
                "WHERE member_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){

            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.setInt(4, member.getMemberId());

            int rows = ps.executeUpdate();

            return rows > 0;

        }catch (SQLException | IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public boolean deleteMember(int id){

        String sql = "DELETE FROM members " +
                "WHERE member_id = ?";

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

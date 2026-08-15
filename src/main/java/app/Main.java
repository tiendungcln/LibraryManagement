package app;

import dao.BookDAO;
import model.Book;
import util.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

public class Main {

    public static void main(String[] args){

        try {

            Connection connection = DBConnection.getConnection();

            if (connection != null){
                System.out.println("Connected Successfully");
                connection.close();
            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}

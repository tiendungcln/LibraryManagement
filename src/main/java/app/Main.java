package app;

import menu.MainMenu;
import util.DBConnection;

import java.sql.Connection;

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

        MainMenu mainMenu = new MainMenu();
        mainMenu.start();

    }

}

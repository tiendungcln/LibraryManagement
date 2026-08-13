package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() throws SQLException, IOException {

        // đọc file properties
        Properties properties = new Properties();
        InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("database.properties");
        properties.load(input);

        if (input == null){
            throw new IOException("Không tìm thấy file database.properties");
        }

        // Lấy thông tin kết nối
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String pass = properties.getProperty("db.pass");

        // Kết nối database
        return DriverManager.getConnection(url, user, pass);

    }

}

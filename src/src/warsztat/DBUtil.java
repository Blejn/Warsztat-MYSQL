package warsztat;

import com.mysql.cj.result.SqlDateValueFactory;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    public static void main(String[] args) throws SQLException {
        Statement statement= getConnection().createStatement();
        
        try {
         getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user=new User();
        user.setId(1);
        user.setUserName("Sebastian");
        user.setEmail("blejntypie@gmail.com");
        user.setPassword("12345678");
        UserDao ud1=new UserDao(user);
        ud1.create(user);

        }


    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=CET";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Seba371216183642";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }




    /*
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

    }*/
}

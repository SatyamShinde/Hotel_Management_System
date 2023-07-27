import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

public class conn
{
    Connection con = null ;
    java.sql.PreparedStatement pst;
    public static Connection dbconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");

            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
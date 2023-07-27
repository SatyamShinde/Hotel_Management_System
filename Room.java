import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Room extends JFrame
{
    JTable table;
    JLabel sr,roomno,availlibility,cleaningstatus,prices,bedtype;
    Room()
    {

        setBounds(500,200,550,600);
        setVisible(true);
        setLayout(null);
        setTitle("Room Availability");

        table = new JTable();
        table.setBounds(20,50,500,500);
        add(table);

        sr = new JLabel("Sr.No");
        sr.setBounds(20,10,50,20);
        add(sr);

        roomno = new JLabel("Room.No");
        roomno.setBounds(100,10,90,20);
        add(roomno);

        availlibility = new JLabel(" Availability");
        availlibility.setBounds(180,10,90,20);
        add(availlibility);

        cleaningstatus = new JLabel("Status");
        cleaningstatus.setBounds(270,10,90,20);
        add(cleaningstatus);

        prices = new JLabel("Price");
        prices.setBounds(350,10,90,20);
        add(prices);

        bedtype = new JLabel("Bed Type");
        bedtype.setBounds(435,10,90,20);
        add(bedtype);




        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");
           String q = "select * from AddRoom";
            Statement s=c1.createStatement();
            ResultSet rs = s.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        new Room();
    }
}

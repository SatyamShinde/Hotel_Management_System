import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class cust_info_room extends JFrame
{
    JTable table ;
    JLabel sr,name,age,gender,mobno,adharno,emailid;
    cust_info_room()
    {
        setBounds(200,200,1200,600);
        setVisible(true);
        setLayout(null);
        setTitle("     Customer.Info {Room}");

        table = new JTable();
        table.setBounds(20,50,1150,500);
        add(table);

        sr = new JLabel("Sr.No");
        sr.setBounds(20,10,50,20);
        add(sr);

        name = new JLabel("Name");
        name.setBounds(200,10,50,20);
        add(name);
        age = new JLabel("Age");
        age.setBounds(380,10,50,20);
        add(age);
        gender = new JLabel("Gender");
        gender.setBounds(560,10,70,20);
        add(gender);
        mobno = new JLabel("Aadhar.No");
        mobno.setBounds(740,10,70,20);
        add(mobno);
        adharno = new JLabel("Mobile.No");
        adharno.setBounds(920,10,70,20);
        add(adharno);
        adharno = new JLabel("Email Id");
        adharno.setBounds(1100,10,50,20);
        add(adharno);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");
            String q = "select * from roombooking";
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
        new cust_info_room();
    }
}

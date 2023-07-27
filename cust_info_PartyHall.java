import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class cust_info_PartyHall extends JFrame
{
    JLabel sr,fname,lname,city,pin,homeph,email;
    JTable table ;
    cust_info_PartyHall()
    {
        setBounds(200,200,1200,600);
        setVisible(true);
        setLayout(null);
        setTitle("     Customer.Info {Room}");

        table = new JTable();
        table.setBounds(20,50,1150,500);
        add(table);

        sr = new JLabel("Sr_No");
        sr.setBounds(30,10,50,20);
        add(sr);
        fname = new JLabel("First Name");
        fname.setBounds(200,10,100,20);
        add(fname);
        lname = new JLabel("Last Name");
        lname.setBounds(370,10,100,20);
        add(lname);
        city = new JLabel("City");
        city.setBounds(540,10,70,20);
        add(city);
        pin = new JLabel("Pin Code");
        pin.setBounds(710,10,70,20);
        add(pin);
        homeph = new JLabel("Phone Number");
        homeph.setBounds(880,10,100,20);
        add(homeph);
        pin = new JLabel("Email Id");
        pin.setBounds(1060,10,70,20);
        add(pin);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");
            String q = "select Sr_No,First,Last,city,zip,Home_Ph,Email_id from partyhallbooking";
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
        new cust_info_PartyHall();
    }
}

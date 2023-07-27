import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class waiter_info extends JFrame
{
    JLabel sr,name,age,gender,Job,salary,mobileno,adharno,email;
    JTable table;
    waiter_info()
    {
           setBounds(100,200,1400,600);
            setVisible(true);
            setLayout(null);
            setTitle("    Waiter/Waitress Information");

            table = new JTable();
            table.setBounds(20,50,1350,500);
            add(table);

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");
                String q = "select * from addemployee where Job = 'Waiter/Waitress'";
                Statement s=c1.createStatement();
                ResultSet rs = s.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs));

                sr = new JLabel("Sr_No");
                sr.setBounds(30,10,50,20);
                add(sr);
                name = new JLabel("Name");
                name.setBounds(180,10,100,20);
                add(name);
                age = new JLabel("Age");
                age.setBounds(330,10,100,20);
                add(age);
                gender = new JLabel("Gender");
                gender.setBounds(480,10,70,20);
                add(gender);
                Job = new JLabel("Job");
                Job.setBounds(630,10,70,20);
                add(Job);
                salary = new JLabel("Salary");
                salary.setBounds(780,10,100,20);
                add(salary);
                mobileno = new JLabel("Mobile Number");
                mobileno.setBounds(930,10,100,20);
                add(mobileno);
                adharno = new JLabel("Aadhar Number");
                adharno.setBounds(1080,10,100,20);
                add(adharno);
                email = new JLabel("Email Id");
                email.setBounds(1240,10,100,20);
                add(email);


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        }


    public static void main(String[] args) {
        new waiter_info();
    }
}

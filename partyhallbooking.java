import com.mysql.cj.jdbc.ha.MultiHostMySQLConnection;
import com.mysql.cj.result.UtilCalendarValueFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.spi.DateFormatProvider;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class partyhallbooking implements ActionListener

{
    JLabel fullname,title,mailing,homephone,workphone,email,noofpeople,size,date;
    JTextField fname,lname,stadress,staddress2,city,zip,workphone2,homephone2,email2,noofpeople2,size2,date2;
    JFrame f = new JFrame();
JComboBox cb;

    JButton jb1;
    partyhallbooking()
    {
        f.getContentPane().setBackground(new Color(216,191,216));
        f.setBackground(Color.RED);
        f.setSize(500, 900);
        f.setTitle("   Party Hall Booking ");
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(560, 20, 400, 820);
        f.setVisible(true);
        f.setLayout(null);


        title = new JLabel("BANQUET BOOKING...");
        title.setBounds(90, 15, 250, 45);
        title.setBackground(Color.YELLOW);
        title.setFont(new Font("Calibri",Font.ITALIC,20));


        fullname = new JLabel(" Name");
        fullname.setBounds(30, 60, 100, 50);


        fname = new JTextField(" First");
        fname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {fname.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        fname.requestFocus();
        fname.setBounds(30, 110, 150, 30);
        fname.setLayout(null);

        lname = new JTextField(" Last");
        lname.setBounds(210,110,150,30);
        lname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {lname.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        lname.requestFocus();
        lname.setLayout(null);

        mailing = new JLabel("Mailing Address");
        mailing.setBounds(30,150,100,50);

        stadress = new JTextField(" Street Address");
        stadress.setBounds(30,200,330,30);
        stadress.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {stadress.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        stadress.requestFocus();

        staddress2=new JTextField(" Street Address Line 2");
        staddress2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {staddress2.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        staddress2.requestFocus();
        staddress2.setBounds(30,250,330,30);


        city = new JTextField(" City");
        city.setBounds(30,300,150,30);
        city.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {city.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        city.requestFocus();

        zip = new JTextField("Postal / Zip Code");
        zip.setBounds(210,300,150,30);
        zip.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {zip.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        zip.requestFocus();
        zip.setLayout(null);

        homephone = new JLabel("Home Phone");
        homephone.setBounds(30,330,100,50);
        homephone2 = new JTextField(" ### ### ####");
        homephone2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {homephone2.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        homephone2.requestFocus();
        homephone2.setBounds(30,380,330,30);

        workphone = new JLabel("Aadhar Number");
        workphone.setBounds(30,410,100,50);
        workphone2 = new JTextField(" ### ### ####");
        workphone2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {workphone2.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        workphone2.requestFocus();
        workphone2.setBounds(30,460,330,30);

        email = new JLabel("Email Id");
        email.setBounds(30,490,100,50);
        email2 = new JTextField("abc@gmail.com");
        email2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {email2.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        email2.requestFocus();
        email2.setBounds(30,540,330,30);

        noofpeople = new JLabel("No of people joining you & Date (DD/MM/YYYY)");
        noofpeople.setBounds(30,570,330,50);
        noofpeople2 = new JTextField(" ### , DD / MM / YYYY");
        noofpeople2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {noofpeople2.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        noofpeople2.requestFocus();
        noofpeople2.setBounds(30,620,330,30);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD/MM/YYYY");
//        LocalDateTime now = LocalDateTime.now();
//        String qw = dtf.format(now);
//        System.out.println(qw);

        size = new JLabel("Size of Party hall");
        size.setBounds(30,650,100,30);

        String s1[] = {"Small (300 X 900)","Medium (1000 X 1500)","Large (1800 X 2500)"};
        cb = new JComboBox(s1);
        cb.setBounds(30,690,330,30);
//        size2 = new JTextField("");

        jb1 = new JButton("Register");
        jb1.setBounds(133,742,105,30);
        jb1.addActionListener(this);


        f.add(title);
        f.add(fullname);
        f.add(fname);
        f.add(lname);
        f.add(mailing);
        f.add(stadress);
        f.add(staddress2);
        f.add(zip);
        f.add(city);
        f.add(homephone);
        f.add(homephone2);
        f.add(workphone);
        f.add(workphone2);
        f.add(email);
        f.add(email2);
        f.add(noofpeople);
        f.add(noofpeople2);
        f.add(size);
        f.add(cb);
        f.add(jb1);



    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root","Qwerty@12345");

            String fna = fname.getText();
            if (fna.equals(""))
            {
                JOptionPane.showMessageDialog(null,"First name should not be empty");
            }
            String lna = lname.getText();
            if (lna.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Last name should not be empty");
            }
            String stadd = stadress.getText();
            if (stadd.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Street Address should not be empty");
            }
            String stadd2 = staddress2.getText();

            String cit = city.getText();
            if (cit.equals(""))
            {
                JOptionPane.showMessageDialog(null,"City should not be empty");
            }
            String code = zip.getText();
            if (code.equals("") )
            {
                JOptionPane.showMessageDialog(null,"Zip code should be a number");
            }

            String hph = homephone2.getText();
            if (hph.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Homephone No should not be a empty");
            }
            String wph = workphone2.getText();
            if (wph.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Aadhar No should not be empty");
            }
            String emai = email2.getText();
            if (emai.equals("")) {
                JOptionPane.showMessageDialog(null,"Invalid Email Id");
            }

            String no = noofpeople2.getText();
            if (no.equals(""))
            {
                JOptionPane.showMessageDialog(null," Enter number of people and Date");
            }
            String pople = (String) cb.getSelectedItem();
            if (pople.equals(""))
            {
                JOptionPane.showMessageDialog(null," Size should not be empty");
            }

            PreparedStatement pst = conn.prepareStatement("insert into partyhallbooking (First,Last,St_Add,St_Add_Line2,city,zip,Home_Ph,Work_Ph,Email_id,People_Date,size) values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,fna);
            pst.setString(2,lna);
            pst.setString(3,stadd);
            pst.setString(4,stadd2);
            pst.setString(5,cit);
            pst.setString(6,code);
            pst.setString(7,hph);
            pst.setString(8,wph);
            pst.setString(9,emai);
            pst.setString(10,no);
            pst.setString(11,pople);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Party Hall Booked Successfully");
            f.setVisible(false);

        }
        catch (Exception ae)
        {
            ae.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new partyhallbooking();
    }


}

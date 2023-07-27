import com.mysql.cj.jdbc.CallableStatementWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class signup extends JFrame implements ActionListener
{
//    JFrame f = new JFrame();
    JLabel firstname,lastname,user,password,email;
    JTextField fname,lname,userid,emailid;
    JPasswordField pass ;
    JButton signup ;
 public signup()
 {

     setSize(500, 600);
     setTitle("   SignUp Form ");
//     f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     setBounds(514, 334, 400, 450);
     setVisible(true);
     setLayout(null);

     firstname = new JLabel("First Name");
     firstname.setBounds(30, 30, 100, 50);

     fname = new JTextField(" ");
     fname.setBounds(150, 40, 200, 30);

     lastname = new JLabel("Last Name");
     lastname.setBounds(30, 90, 100, 50);

     lname = new JTextField("");
     lname.setBounds(150, 100, 200, 30);

     user = new JLabel("User Name");
     user.setBounds(30,150,100,50);
     userid = new JTextField("");
     userid.setBounds(150,160,200,30);

     password = new JLabel("Password");
     password.setBounds(30,210,100,50);
     pass = new JPasswordField();
     pass.setBounds(150,220,200,30);

     email = new JLabel(" Email Id");
     email.setBounds(30,270,100,50);
     emailid = new JTextField();
     emailid.setBounds(150,280,200,30);

     signup = new JButton(" Sign Up");
     signup.setBounds(150,340,100,30);
     signup.addActionListener(this);



     add(firstname);
     add(lastname);
     add(fname);
     add(lname);
     add(user);
     add(userid);
     add(pass);
     add(password);
     add(email);
     add(emailid);
     add(signup);
}

    @Override
    public void actionPerformed(ActionEvent e) {

     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root","Qwerty@12345");

         String u = userid.getText();
         String v = pass.getText();

         String q = "select * from login where username='"+u+"' and password='"+v+"'";




         String first = fname.getText();
         String last = lname.getText();
         String username = userid.getText();
         String passw = pass.getText();
         String email = emailid.getText();

         PreparedStatement pst = con.prepareStatement("insert into signup (fname,lname,username,password,email_id) values(?,?,?,?,?)");
         pst.setString(1,first);
         pst.setString(2,last);
         pst.setString(3,username);
         pst.setString(4,passw);
         pst.setString(5,email);
         pst.executeUpdate();
         JOptionPane.showMessageDialog(null,"Signup Successfull");
         setVisible(false);
     }
     catch (Exception ez)
     {
         ez.printStackTrace();

     }
    }
    public static void main(String[] args)
    {
        new signup();
    }
}
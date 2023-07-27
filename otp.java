
import javax.swing.*;
import java.awt.*;

public class otp extends JFrame  {
    JLabel firstname, lastname, user, password, email,otp;
    JTextField fname, lname, userid, otptxt;
    JPasswordField pass;
    JButton signup,verify;


    public otp() {

        setSize(500, 600);
        setTitle("   SignUp Form ");
        setBounds(514, 334, 400, 500);
        setVisible(true);
        setLayout(null);

        firstname = new JLabel("Name");
        firstname.setBounds(30, 30, 100, 50);

        fname = new JTextField(" ");
        fname.setBounds(150, 40, 200, 30);

        lastname = new JLabel("Mobile Number");
        lastname.setBounds(30, 90, 100, 50);

        lname = new JTextField("");
        lname.setBounds(150, 100, 200, 30);

        user = new JLabel("User Name");
        user.setBounds(30, 150, 100, 50);
        userid = new JTextField("");
        userid.setBounds(150, 160, 200, 30);

        password = new JLabel("Password");
        password.setBounds(30, 210, 100, 50);
        pass = new JPasswordField();
        pass.setBounds(150, 220, 200, 30);

        signup = new JButton(" LOGIN");
        signup.setBounds(150, 280, 100, 30);
//        signup.addActionListener(this);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        otp = new JLabel(" OTP");
        otp.setBounds(30, 330, 100, 50);
        otptxt = new JTextField();
        otptxt.setBounds(150, 340, 200, 30);


        verify = new JButton("VERIFY");
        verify.setBounds(150,400,100,30);
//        verify.addActionListener(this);
        verify.setBackground(Color.BLACK);
        verify.setForeground(Color.WHITE);

        add(firstname);
        add(lastname);
        add(fname);
        add(lname);
        add(user);
        add(userid);
        add(pass);
        add(password);
        add(otp);
        add(otptxt);
        add(signup);
        add(verify);

    }


    public static void main(String[] args)
    {
      new otp();
        }
    }

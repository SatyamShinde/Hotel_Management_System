import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class roombooking  implements ActionListener
{
    JLabel name,age,gender,aadhar,mobile,email;
    JButton submit;
    JRadioButton males,females;
    JTextField fname,fage,faadhar,fmobile,femail;
    JFrame f = new JFrame();
    roombooking() {

//        f.setSize(500, 600);
        f.setTitle("   Room Booking ");
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(560, 250, 400, 500);
        f.setVisible(true);
        f.setLayout(null);

        name = new JLabel("Full Name");
        name.setBounds(30, 30, 100, 50);

        fname = new JTextField(" ");
        fname.setBounds(150, 40, 200, 30);


        age = new JLabel("Age");
        age.setBounds(30, 90, 100, 50);

        fage = new JTextField("");
        fage.setBounds(150, 100, 200, 30);

        gender = new JLabel("Gender");
        gender.setBounds(30, 150, 100, 50);

         males = new JRadioButton("Male");
        males.setBounds(150, 140, 200, 30);
         females = new JRadioButton("Female");
        females.setBounds(150, 180, 200, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(males);
        bg.add(females);


        aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(30, 210, 100, 50);

        faadhar = new JTextField("");
        faadhar.setBounds(150, 220, 200, 30);

        mobile = new JLabel("Mobile No.");
        mobile.setBounds(30, 270, 100, 50);

        fmobile = new JTextField("");
        fmobile.setBounds(150, 280, 200, 30);

        email = new JLabel("Email Id.");
        email.setBounds(30, 330, 100, 50);

        femail = new JTextField("");
        femail.setBounds(150, 340, 200, 30);

        submit = new JButton("SUBMIT");
        submit.setBounds(140, 400, 100, 40);
        submit.addActionListener(this);

//        try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root","Qwerty@12345");
//
//                String q = "insert into roomb values ('" + name + "' , '" + age + "' ,'" + gender + "' , '" + aadhar + "' , '" + mobile + "','" + email + "') ";
//
//
//                Statement s=c1.createStatement();
//                ResultSet rs = s.executeQuery(q);
//        }
//        catch (Exception e)
//        {
//                e.printStackTrace();
//        }


        f.add(name);
        f.add(age);
        f.add(gender);
        f.add(aadhar);
        f.add(mobile);
        f.add(email);
        f.add(submit);
        f.add(fname);
        f.add(fage);
        f.add(faadhar);
        f.add(fmobile);
        f.add(femail);
        f.add(males);
        f.add(females);
    }

        @Override
        public void actionPerformed (ActionEvent e)
        {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
//
                Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root","Qwerty@12345");
                String name = fname.getText();
                if (name.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Name should not be empty");
                }
                String age = fage.getText();
                if (age.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Age should not be empty");
                }
                String gen = null;
                if (males.isSelected())
                {
                    gen="Male";
                } else if (females.isSelected())
                {
                    gen="female";
                }
                String adhar = faadhar.getText();
                if (adhar.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Adhar No should not be empty");
                }
                String mobile = fmobile.getText();
                if (mobile.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Mobile No should not be empty");
                }
                String email = femail.getText();
                if (email.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Email Id should not be empty");
                }

                PreparedStatement pst = c1.prepareStatement("insert into roombooking (Full_Name,Age,Gender,Adhar_No,Mobile_No,Email_id) values (?,?,?,?,?,?)");
                pst.setString(1, name);
                pst.setString(2, age);
                pst.setString(3,gen);
                pst.setString(4, adhar);
                pst.setString(5, mobile);
                pst.setString(6, email);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Room Booked Successfully");
                f.setVisible(false);
            }
            catch (Exception ae)
            {
                ae.printStackTrace();
            }
        }
    public static void main(String[] args)
    {
            new roombooking();
    }
}




import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ //Third Frame


    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    JComboBox zz;
    JRadioButton Male,Female;

    public AddEmployee(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("Name");

        Passportno.setBounds(60, 30, 150, 27);
        add(Passportno);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JButton Next = new JButton("SAVE");
        Next.setBounds(200, 450, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);
        Next.addActionListener(this);

        JLabel Pnrno = new JLabel("Age");

        Pnrno.setBounds(60, 80, 150, 27);
        add(Pnrno);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

         Male = new JRadioButton("Male");
        Male.setBackground(Color.WHITE);
        Male.setBounds(200, 120, 70, 27);
        add(Male);

         Female = new JRadioButton("Female");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 120, 70, 27);
        add(Female);
        ButtonGroup btg = new ButtonGroup();
        btg.add(Male);
        btg.add(Female);

        JLabel Address = new JLabel("Job");
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        String ss[] = {"Porters","Housekeeping","Waiter/Waitress","Manager","Accountant","Chef"};
        zz = new JComboBox(ss);
        zz.setBackground(Color.WHITE);
        zz.setBounds(200,170,150,30);
        add(zz);

        JLabel Nationality = new JLabel("Salary");
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("Phone");
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel Phno = new JLabel("Aadhar Number");
        Phno.setBounds(60, 320, 150, 27);
        add(Phno);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);


        JLabel email = new JLabel("Email");
        email.setBounds(60, 370, 150, 27);
        add(email);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        ImageIcon i1 = new ImageIcon("C:\\Users\\satya\\Desktop\\addemployee.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 415, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 460, 550);
        add(image);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.GRAY);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);
        setSize(900,600);
        setLocation(300,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");

        String name = textField.getText();
        String age = textField_1.getText();
        String gender = null;

        if (Male.isSelected())
        {
            gender="male";
        } else if (Female.isSelected())
        {
            gender = "female";
        }

        String job = (String) zz.getSelectedItem();
        String salary = textField_3.getText();
        String phone = textField_4.getText();
        String aadhar = textField_5.getText();
        String email = textField_6.getText();

        PreparedStatement pst = c1.prepareStatement("insert into AddEmployee(Name,Age,Gender,Job,Salary,Phone,Aadhar,Email) values(?,?,?,?,?,?,?,?)");
        pst.setString(1,name);
        pst.setString(2,age);
        pst.setString(3,gender);
        pst.setString(4,job);
        pst.setString(5,salary);
        pst.setString(6,phone);
        pst.setString(7,aadhar);
        pst.setString(8,email);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Employee Added Successfully");
        setVisible(false);

        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new AddEmployee();
    }
}
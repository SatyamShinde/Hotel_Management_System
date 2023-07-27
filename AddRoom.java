
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener {

     JPanel contentPane;
     JTextField t2,t4;
     JComboBox comboBox, comboBox_2, comboBox_3;
    JButton b1,b2;

    public AddRoom() {

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\satya\\Desktop\\roombooking.jpg");
        Image i2 = i1.getImage().getScaledInstance(500, 415, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 500, 415);
        contentPane.add(image);

        JLabel l10 = new JLabel("Add Rooms");
        l10.setBounds(680, 10, 120, 22);
        contentPane.add(l10);
        l10.setFont(new Font("Calibri",Font.ITALIC,22));

        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setBounds(600, 70, 120, 22);
        contentPane.add(l1);


        t4 = new JTextField();
        t4.setBounds(750, 70, 156, 20);
        contentPane.add(t4);


        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setBounds(600, 110, 102, 22);
        contentPane.add(l2);

        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox.setBounds(750, 110, 154, 20);
        contentPane.add(comboBox);


        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setBounds(600, 150, 120, 22);
        contentPane.add(l3);

        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        comboBox_2.setBounds(750, 150, 154, 20);
        contentPane.add(comboBox_2);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setBounds(600, 190, 102, 22);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(750, 190, 156, 20);
        contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setBounds(600, 230, 102, 22);
        contentPane.add(l5);

        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
        comboBox_3.setBounds(750, 230, 154, 20);
        contentPane.add(comboBox_3);

        b1 = new JButton("ADD");
        b1.setBounds(600, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("BACK");
        b2.setBounds(750, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);
        contentPane.setBackground(Color.WHITE);
        b2.addActionListener(this);

        setBounds(250, 200, 1000, 450);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==b1)
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");

                    String room = t4.getText();
                    String available =(String) comboBox.getSelectedItem();
                    String cleaned = (String) comboBox_2.getSelectedItem();
                    String price = t2.getText();
                    String bed  = (String) comboBox_3.getSelectedItem();

                    PreparedStatement pst = c1.prepareStatement("insert into AddRoom(Room_Number, Availability, Cleaning_Status, Price, Bed_Type) values(?,?,?,?,?)");
                    pst.setString(1,room);
                    pst.setString(2,available);
                    pst.setString(3,cleaned);
                    pst.setString(4,price);
                    pst.setString(5,bed);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Room Added Successfully");
                    setVisible(false);


                }
                catch (Exception ee)
                {
                    ee.printStackTrace();
                }
            } else if (e.getSource()==b2)
            {
                this.setVisible(false);
            }
        }
        catch (Exception eee)
        {
            eee.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new AddRoom();
    }
}
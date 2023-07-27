import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;

public class loginpanal implements ActionListener
{
    JTextField t1,t2;
    JFrame f ;
    JButton jb1,jb2;
    loginpanal()
    {

         f= new JFrame("Login Field");

        t1=new JTextField("Enter Username... ");
        t1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {t1.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        t1.requestFocus();
        t1.setBounds(47,25,300,30);
        t1.setBackground(new Color(231, 242, 241));

        t2=new JPasswordField("Enter Password ");
        t2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {t2.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });
        t2.requestFocus();
        t2.setBounds(47,80,300,30);
        t2.setBackground(new Color((231), 242, 241));

        jb1 = new JButton("Login");
        jb1.setBounds(47,130,100,40);
        jb1.addActionListener(this);

        jb2 = new JButton("Sign Up");
        jb2.setBounds(250,130,100,40);
        jb2.addActionListener(this);

        f.add(t1);
        f.add(t2);
        f.add(jb1);
        f.add(jb2);

        f.setSize(400,225);
        f.setBounds(510,560,400,225);
        f.setLayout(null);
        f.setVisible(true);
        f.setBackground(new Color(1,1,1,80)); //bg color should not be null with alfa value
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jb1){
            try{
//                conn c1 = new conn();
//                Connection c1 = new DriverManager.getConnection();
                Connection c1= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root","Qwerty@12345");
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from signup where username='"+u+"' and password='"+v+"'"; // prepare query from text field

                //need to prepare statment object here
                Statement s=c1.createStatement();

                ResultSet rs = s.executeQuery(q); //save dataset to rs

                if(rs.next()){ //if rs got credential then



                    JOptionPane.showMessageDialog(null,"Login Successfull...");

//                    f.setVisible(false); //disable login popup
                      f.dispose(); //close
//                      new Menu_(); //launch menu_
//new Main();
//new roombooking();
                    new Menu();


                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    f.setVisible(true);
                }
            }   catch(Exception e){
               // System.out.println("error");
//                e.printStackTrace();
                System.err.println(e);
            }
        }else if(ae.getSource()==jb2)
        {
//            System.exit(0);
            new signup();
        }
    }
    public static void main(String[] args)
    {
        new loginpanal();
    }
}


class Menu_
{
    static JFrame mymenu=new JFrame("test");
    Menu_()
    {
        mymenu.setBounds(0, 0, 1920, 1020);
        mymenu.setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\satya\\Desktop\\back2.jpg");
        Image i2 = i1.getImage().getScaledInstance(1920, 1020, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1020);
        mymenu.add(image);


        JLabel name = new JLabel("Celebrating 100 Years Of History 'Rock_N_Roll' Resturant ");
        name.setBounds(450,70,1920,100);
        name.setForeground(Color.WHITE);
        image.add(name);
        Font ff = new Font( "Franklin Gothic Medium",Font.BOLD,30);
        name.setFont(ff);
        mymenu.setVisible(true);



        JMenuBar menubar = new JMenuBar();
        menubar.setBounds(0,0,1920,30);
        image.add(menubar);


        JMenu menu = new JMenu("     Menu     ");
        JMenu booking = new JMenu("     Booking     ");
        JMenu customer = new JMenu("     Customer     ");
        JMenu admin = new JMenu("     Admin     ");
        JMenu report = new JMenu("     Report     ");

        JMenuItem i9 = new JMenuItem("A");
        JMenuItem i8 = new JMenuItem("B");
        JMenuItem i7 = new JMenuItem("C");
        JMenuItem i6 = new JMenuItem("D");

        JMenuItem rm = new JMenuItem("Room Booking");
      //  rm.addActionListener(this);
        JMenuItem hb = new JMenuItem("Party Hall Booking");

        JMenuItem ae = new JMenuItem("Add New Employee");
        JMenuItem ar = new JMenuItem("Add New Rooms");
        JMenuItem ad = new JMenuItem("Add New Car Driver");

        JMenuItem ci = new JMenuItem("Check In");
        JMenuItem co = new JMenuItem("Check Out");
        JMenuItem cri = new JMenuItem("Customer room Info");

//            heading.add(menubar);
        menu.add(i9);
        menu.add(i8);
        menu.add(i7);
        menu.add(i6);
        booking.add(rm);
        booking.add(hb);
        admin.add(ar);
        admin.add(ae);
        admin.add(ad);
        customer.add(ci);
        customer.add(co);
        customer.add(cri);
        menubar.add(menu);
        menubar.add(booking);
        menubar.add(customer);
        menubar.add(admin);
        menubar.add(report);



        mymenu.setVisible(true);
        while (true)
        { name.setVisible(false);
            try{

                Thread.sleep(500);
            }catch (Exception e )
            {
                System.out.println(e);
            }
            name.setVisible(true);
            try
            {

                Thread.sleep(1500);
            }
            catch (Exception e )
            {
                System.out.println(e);
            }
        }
    }}
/*   @Override
    public void actionPerformed(ActionEvent e)
    {
        new roombooking();
    }


    public static void main(String[] args)
    {
        new Menu();

    }
}*/

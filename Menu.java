import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu extends JFrame  {

    Menu() {

//        JButton button= new JButton("Logout");
//        button.setBounds(500,500,111,20);
//        button.setBackground(Color.BLACK);
//        button.setForeground(Color.WHITE);

        setBounds(0, 0, 1920, 1020);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\satya\\Desktop\\back2.jpg");
        Image i2 = i1.getImage().getScaledInstance(1920, 1020, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1020);
        add(image);

        JLabel name = new JLabel("Celebrating 100 Years Of History 'Royal Crest' Resturant ");
        name.setBounds(410, 70, 1920, 100);
        name.setForeground(Color.WHITE);
        image.add(name);
        Font ff = new Font("Franklin Gothic Medium", Font.BOLD, 30);
        name.setFont(ff);
        setVisible(true);

        JButton button= new JButton("<< LOGOUT");
        button.setBounds(1350,760,120,35);
        image.add(button);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Logout Successfull...");
                new Main();
                setVisible(false);
            }
        });

        JMenuBar menubar = new JMenuBar();
        menubar.setBounds(0, 0, 1920, 30);
        image.add(menubar);

        JMenu menu = new JMenu("     Menu     ");
        JMenu booking = new JMenu("     Booking     ");
//        JMenu customer = new JMenu("     Customer     ");
        JMenu admin = new JMenu("     Admin     ");
//        JMenuItem feedback = new JMenuItem("     FeedBack     ");
//        feedback.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    new feedback().setVisible(true);
//                }
//                catch (Exception ez)
//                {
//                    ez.printStackTrace();
//                }
//            }
//        });
        JMenu re = new JMenu("     Feedback     ");
        JMenuItem re1 = new JMenuItem("Write Feedback");
        re1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new feedback().setVisible(true);
                }
                catch (Exception hi)
                {
                    hi.printStackTrace();
                }
            }
        });
        JMenuItem i9 = new JMenuItem("Add New Employee");
        i9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddEmployee().setVisible(true);
                }
                catch (Exception ez)
                {
                    ez.printStackTrace();
                }
            }
        });
        JMenuItem i8 = new JMenuItem("Add New Rooms");
        i8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddRoom().setVisible(true);
                }
                catch (Exception yz)
                {
                    yz.printStackTrace();
                }
            }
        });
        JMenuItem i7 = new JMenuItem("Add New Car Driver");
        i7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new AddDrivers().setVisible(true);
                }
                catch (Exception ee)
                {
                    ee.printStackTrace();
                }
            }
        });
//        JMenuItem i6 = new JMenuItem("D");

        JMenuItem rm = new JMenuItem("Room Booking");
        rm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new roombooking().f.setVisible(true);
                }
                catch(Exception eee)
                {
                    eee.printStackTrace();
                }
            }
        });
        JMenuItem hb = new JMenuItem("Party Hall Booking");
        hb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new partyhallbooking().f.setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }
            }
        });

        JMenuItem ae = new JMenuItem("Room Status");
        ae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room().setVisible(true);
                }
                catch (Exception qp)
                {
                    qp.printStackTrace();
                }
            }
        });
        JMenuItem ar = new JMenuItem("Customer Info {Room}");
        ar.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     try {
                                         new cust_info_room().setVisible(true);
                                     }catch (Exception qw)
                                     {
                                         qw.printStackTrace();
                                     }}
                                 });
        JMenuItem ad = new JMenuItem("Customer Info {Party Hall}");
                                 ad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        new cust_info_PartyHall().setVisible(true);
                    }catch (Exception qw)
                    {
                        qw.printStackTrace();
                    }}
                });
        JMenu aa = new JMenu("About Employee");


        JMenuItem e = new JMenuItem("Porters");
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new porter_info().setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }}
        });
        JMenuItem r = new JMenuItem("Housekeeping");
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new housekipping_info().setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }}
        });
        JMenuItem u = new JMenuItem("Waiter/Waitress");
        u.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new waiter_info().setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }}
        });
        JMenuItem i = new JMenuItem("Manager");
        i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new manager_info().setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }}
        });
        JMenuItem o = new JMenuItem("Accountant");
        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new accountant_info().setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }}
        });
        JMenuItem p = new JMenuItem("Chef");
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new chef_info().setVisible(true);
                }catch (Exception qw)
                {
                    qw.printStackTrace();
                }}
        });

        aa.add(e);aa.add(r);aa.add(u);aa.add(i);aa.add(o);aa.add(p);
        re.add(re1);

        JMenuItem ci = new JMenuItem("Check In");
        JMenuItem co = new JMenuItem("Check Out");

//            heading.add(menubar);

        menu.add(i9);
        menu.add(i8);
        menu.add(i7);
//        menu.add(i6);
        booking.add(rm);
        booking.add(hb);
        admin.add(ae);
        admin.add(ar);
        admin.add(ad);
        admin.add(aa);
//        customer.add(ci);
//        customer.add(co);
//        customer.add(cri);
        menubar.add(menu);
        menubar.add(booking);
//        menubar.add(customer);
        menubar.add(admin);
//        menubar.add(feedback);
        menubar.add(re);




//        setVisible(true);
//        while (true)
//        { name.setVisible(false);
//            try{
//
//                Thread.sleep(500);
//            }catch (Exception ee )
//            {
//                System.out.println(ee);
//            }
//            name.setVisible(true);
//            try
//            {
//
//                Thread.sleep(1500);
//            }
//            catch (Exception ef )
//            {
//                System.out.println(ef);
//            }
//        }

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//            if (e.getActionCommand().equals("Room Booking")) ;
//            {
//                new roombooking();
//            }
////        else if (e.getActionCommand().equals("Party Hall Booking")) ;
////            {
////                new partyhallbooking();
////            }
////



    public static void main(String[] args)
    {
        new Menu();
    }
}
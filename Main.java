import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;
import java.awt.event.WindowAdapter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
public class Main extends JFrame implements ActionListener {
//    JFrame f = new JFrame();
JOptionPane jp;
    Main() {
        // Font
        Font f = new Font("Franklin Gothic Medium", Font.BOLD, 20);
        // Label
        JLabel background, name;
        // Panel
        JPanel heading;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // header
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 50));
        heading.setBounds(0, 0, 1200, 30);
        // button next
        JButton next = new JButton("Next >>");
        next.setBounds(1025, 600, 95, 35);
        next.addActionListener(this);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Sign Up ");}});
        // header name
        name = new JLabel(" Welcome To 'Royal Crest' Resturant");
        name.setBounds(428, 15, 600, 100);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        // Background Img Setting
        ImageIcon backimage = new ImageIcon("C:\\Users\\satya\\Desktop\\desk hotel.jpg");
        Image img = backimage.getImage();
        Image temp_img = img.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        backimage = new ImageIcon(temp_img);
        background = new JLabel(backimage, JLabel.CENTER);
        // Menu Bar
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("   Menu   ");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Click On Next And Login");
            }
        });
        JMenu booking = new JMenu("   Booking   ");
        JMenu customer = new JMenu("   Customer   ");
        JMenu admin = new JMenu("   Admin   ");
        JMenu report = new JMenu("   Report   ");

//        JMenuItem i1 = new JMenuItem("A");
//        JMenuItem i2 = new JMenuItem("B");
//        JMenuItem i3 = new JMenuItem("C");
//        JMenuItem i4 = new JMenuItem("D");

//        JMenuItem rm = new JMenuItem("Room Booking");
//        JMenuItem hb = new JMenuItem("Party Hall Booking");

//        JMenuItem ae = new JMenuItem("Add New Employee");
//        JMenuItem ar = new JMenuItem("Add New Rooms");
//        JMenuItem ad = new JMenuItem("Add New Car Driver");
//
//        JMenuItem ci = new JMenuItem("Check In");
//        JMenuItem co = new JMenuItem("Check Out");
//        JMenuItem cri = new JMenuItem("Customer room Info");

        // For Adding
        background.setBounds(0, 0, 1200, 700);
        add(background);
        background.add(heading);
        background.add(name);
        background.add(next);
//        background.add(login);
//        login.add(username);
//        login.add(password);
//        login.add(jb1);
//        login.add(jb2);
        heading.add(menubar);
//        menu.add(i1);
//        menu.add(i2);
//        menu.add(i3);
//        menu.add(i4);
//        booking.add(rm);
//        booking.add(hb);
//        admin.add(ar);
//        admin.add(ae);
//        admin.add(ad);
//        customer.add(ci);
//        customer.add(co);
//        customer.add(cri);
        menubar.add(menu);
        menubar.add(booking);
        menubar.add(customer);
        menubar.add(admin);
        menubar.add(report);

        // frame
        setSize(1200, 700);
        setBounds(160, 100, 1200, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("   Hotel_Management_System");
        setVisible(true);
//
//        // Add a window state listener
//        this.addWindowStateListener(new WindowStateListener() {
//            @Override
//            public void windowStateChanged(WindowEvent e) {
//                // Check if the window is minimized
//                if (e.getNewState() == Frame.ICONIFIED) {
//                    // Perform desired action (e.g., close the frame)
////                    setVisible(false);
//                    dispose();
//                    // Additional custom action if needed
//                }
//            }
//        });
//
//        // Add a window adapter to handle window closing
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // Perform cleanup or additional actions if needed
////                System.exit(0);
//                dispose();
//            }
//        });


        // Add a window focus listener to the first frame
   /*     this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                // No action needed when the first frame gains focus
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // Close the first frame when it loses focus
                dispose();
            }
        });

        // Add a window adapter to handle window closing for the second frame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Perform cleanup or additional actions if needed
                System.exit(0);
            }
        });

*/


    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            new  loginpanal();
            this.dispose();

        } catch (Exception ex) {
           ex.printStackTrace();
        }


    }
    public static void main(String[] args)
    {
        Main mn= new Main();

    }
}

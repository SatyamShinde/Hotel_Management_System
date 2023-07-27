import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class feedback extends JFrame implements ActionListener
{
    JButton jb ;
    JTextArea ja;
    feedback()
    {
        setVisible(true);
        setLayout(null);
        setBounds(500,250,500,350);
        setTitle("Feedback Form");
        getContentPane().setBackground(new Color(121,100,125));
        ja = new JTextArea("  Write Your Feedback Here");
        ja.setBounds(40,40,400,200);
        ja.setFont(new Font("Tahoma", Font.TYPE1_FONT, 15));
        ja.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {ja.selectAll();}
            @Override
            public void focusLost(FocusEvent e) {}
        });

         jb = new JButton("Submit");
        jb.setBackground(Color.BLACK);
        jb.setForeground(Color.WHITE);
        jb.addActionListener(this);
        jb.setBounds(195,260,100,30);


        add(ja);
        add(jb);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == jb) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "Qwerty@12345");

                    String feedback = ja.getText();

                    PreparedStatement pst = c1.prepareStatement("insert into feedback (Feedback) values(?)");
                    pst.setString(1,feedback);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Feedback Successfully Submited");
                    setVisible(false);

                } catch (Exception eq) {
                    eq.printStackTrace();
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void main(String[] args) {
        new feedback();
    }


}

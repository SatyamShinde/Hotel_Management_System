import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class sample {

    public class MenuBar implements ActionListener {
        JMenuBar jMenuBar;
        JMenu file, edit, view, format;
        JMenuItem cut, copy, paste, save, exit, delete, zoom;
        JTextArea jTextArea;

        MenuBar() {
            JFrame m = new JFrame();
            m.setSize(300, 650);
            m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            m.setTitle("notepad");
            m.setBackground(Color.BLACK);

            jMenuBar = new JMenuBar();

            jTextArea = new JTextArea("write here..!");
            jTextArea.setBounds(20,20,250,400);
//            jTextArea.setText("Initial text"); // Set initial text
            jTextArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Set the font
            jTextArea.setForeground(Color.BLACK); // Set text color
            jTextArea.setBackground(Color.WHITE); // Set background color
            jTextArea.setLineWrap(true); // Enable automatic line wrapping
            jTextArea.setWrapStyleWord(true);
            file = new JMenu("File");
            edit = new JMenu("Edit");
            view = new JMenu("View");
            format = new JMenu("Format"); // Uncomment this line to create the "Format" menu
            //   jMenuBar.setBounds(0, 0, 300, 30);

            cut = new JMenuItem("Cut");
            copy = new JMenuItem("Copy");
            paste = new JMenuItem("Paste");
            save = new JMenuItem("Save As...");
            exit = new JMenuItem("Exit");
            zoom = new JMenuItem("Zoom");

            cut.addActionListener(this);
            copy.addActionListener(this);
            paste.addActionListener(this);
            //   save.addActionListener(this);
            //   zoom.addActionListener(this);

            exit.addActionListener(
                    new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int option = JOptionPane.showConfirmDialog(
                                    null,
                                    "Do you want to continue?",
                                    "Confirmation",
                                    JOptionPane.YES_NO_OPTION
                            );
                            if (option == JOptionPane.YES_OPTION) {
                                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            } else {
                                System.out.println("You chose No!");
                            }
                        }
                    }
            );

            edit.add(copy);
            edit.add(paste);
            file.add(save);
            file.add(exit);
            view.add(zoom);

            jMenuBar.add(file);
            jMenuBar.add(edit);
            jMenuBar.add(view);
            jMenuBar.add(format);

            m.add(jTextArea);
            m.add(jMenuBar);
            m.setJMenuBar(jMenuBar);
            m.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            // Object source=e.getSource();
            if (e.getSource() == cut) {
                jTextArea.cut();
            }
            if (e.getSource() == copy) {
                jTextArea.copy();
            }
            if (e.getSource() == paste) {
                jTextArea.paste();
            }
        }
    }

    public static void main(String args[]) {
        sample ms = new sample();
        MenuBar mb = ms.new MenuBar();
    }
}
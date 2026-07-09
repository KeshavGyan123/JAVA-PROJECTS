package StudentManagementSystem.src.studentApp;
// package studentApp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
// import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class Dashboard extends JFrame implements ActionListener {

    private StudentManager manager;

    JButton addButton, viewButton, searchButton, updateButton, deleteButton, saveButton, exitButton;

    public Dashboard(StudentManager manager) {
    this.manager = manager;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Management System");
        // setVisible(true);

        // ================= Dashboard Heading =================

        JLabel heading = new JLabel("STUDENT MANAGEMENT SYSTEM");
        heading.setBounds(250, 30, 600, 40);
        heading.setFont(new Font("SansSerif", Font.BOLD, 32));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        JLabel welcome = new JLabel("Welcome, Admin");
        welcome.setBounds(420, 85, 250, 30);
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 20));
        welcome.setForeground(Color.DARK_GRAY);
        add(welcome);

        JSeparator line = new JSeparator();
        line.setBounds(30, 130, 1020, 2);
        add(line);

        // ================= Dashboard Image =================


        String path = "StudentManagementSystem/src/studentApp/icons/dashboard_bg.png";
ImageIcon i1 = new ImageIcon(path);

        // ImageIcon i1 = new ImageIcon("src/studentApp/icons/dashboard_bg.png");
        // ImageIcon i1 = new ImageIcon("StudentManagementSystem/icons/dashboard_bg.png");
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(30, 150, 350, 350);
        add(image);


        // ================= Dashboard Buttons =================

        addButton = new JButton("Add Student");
        addButton.setBounds(470, 180, 180, 40);
        addButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        addButton.setBackground(new Color(22, 99, 54));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.addActionListener(this);
        add(addButton);


        viewButton = new JButton("View Students");
        viewButton.setBounds(470, 250, 180, 40);
        viewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        viewButton.setBackground(new Color(22, 99, 54));
        viewButton.setForeground(Color.WHITE);
        viewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewButton.setFocusPainted(false);
        viewButton.addActionListener(this);
        add(viewButton);

        searchButton = new JButton("Search Students");
        searchButton.setBounds(700, 180, 180, 40);
        searchButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        searchButton.setBackground(new Color(22, 99, 54));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.addActionListener(this);
        add(searchButton);

       
        updateButton = new JButton("Update Students");
        updateButton.setBounds(700, 250, 180, 40);
        updateButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        updateButton.setBackground(new Color(22, 99, 54));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateButton.addActionListener(this);
        add(updateButton);


        deleteButton = new JButton("Delete Students");
        deleteButton.setBounds(470, 320, 180, 40);
        deleteButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        deleteButton.setBackground(new Color(178, 34, 34));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);
        add(deleteButton);

        
        saveButton = new JButton("Save Records");
        saveButton.setBounds(700, 320, 180, 40);
        saveButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        saveButton.setBackground(new Color(0, 102, 204));   // Blue
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.addActionListener(this);
        add(saveButton);

       // Exit Button
         exitButton = new JButton("Exit");
         exitButton.setBounds(585, 410, 180, 40);
         exitButton.setFont(new Font("SansSerif", Font.BOLD, 15));
         exitButton.setBackground(Color.DARK_GRAY);
         exitButton.setForeground(Color.WHITE);
         exitButton.setFocusPainted(false);
         exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         exitButton.addActionListener(this);
         add(exitButton);

         revalidate();
         repaint();
        setVisible(true);

   }

   @Override
public void actionPerformed(ActionEvent e){

    if(e.getSource() == addButton){

        setVisible(false);
        // new AddStudent(new StudentManager());
        new AddStudent(manager);

    }
    else if(e.getSource() == viewButton){

        setVisible(false);
        // new ViewStudents(new StudentManager());
        new ViewStudents(manager);

    }
    else if(e.getSource() == searchButton){

        setVisible(false);
        new SearchStudent(manager);

    }
    else if(e.getSource() == updateButton){

        setVisible(false);
        new UpdateStudent(manager);

    }
    else if(e.getSource() == deleteButton){

        setVisible(false);
        new DeleteStudent(manager);

    }
   else if (e.getSource() == saveButton) {

    FileManager.saveStudents(manager.getAllStudents());

    JOptionPane.showMessageDialog(
            null,
            "Records Saved Successfully!"
    );

}
    else if(e.getSource() == exitButton){

        System.exit(0);

    }

}
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        new Dashboard(manager);

    }

}



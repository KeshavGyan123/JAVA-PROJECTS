package StudentManagementSystem.src.studentApp;

// package studentApp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame  implements ActionListener{
   

    // ================= Text Fields =================

     JTextField txtStudentId;
     JTextField txtName;
     JTextField txtAge;

     // ================= Combo Boxes =================

    JComboBox<String> cmbCourse;
    JComboBox<String> cmbYear;

    // ================= Radio Buttons =================

    JRadioButton rbMale;
    JRadioButton rbFemale;
    ButtonGroup genderGroup;

 // ================= Save  Buttons =================
    JButton btnSave;

   JButton btnBack; 

   //  private StudentManager manager = new StudentManager();


   // public AddStudent(){


   private StudentManager manager;

   public AddStudent(StudentManager manager) {
   this.manager = manager;

    // existing constructor code
   

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    // ================= Heading =================

    JLabel heading = new JLabel("ADD NEW STUDENT");
    heading.setBounds(250, 25, 400, 40);
    heading.setFont(new Font("SansSerif", Font.BOLD, 30));
    heading.setForeground(new Color(22, 99, 54));
    add(heading);

    // ================= Student Image =================

     String path = "StudentManagementSystem/src/studentApp/icons/add_student.jpg";
     ImageIcon i1 = new ImageIcon(path);

    // ImageIcon i1 = new ImageIcon("src/studentApp/icons/add_student.jpg");
    //  ImageIcon i1 = new ImageIcon("StudentManagementSystem/icons/add_student.jpg");
    //  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_student.jpg"));
     Image i2 = i1.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(40, 120, 220, 220);
     add(image);


     // ================= Student ID =================

        JLabel lblStudentId = new JLabel("Student ID");
        lblStudentId.setBounds(320, 140, 120, 30);
        lblStudentId.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(lblStudentId);


        txtStudentId = new JTextField();
        txtStudentId.setBounds(450, 140, 220, 30);
        txtStudentId.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(txtStudentId);
  

      // ================= Name =================

           JLabel lblName = new JLabel("Name");
           lblName.setBounds(320, 200, 120, 30);
           lblName.setFont(new Font("SansSerif", Font.BOLD, 18));
           add(lblName);
           txtName = new JTextField();
           txtName.setBounds(450, 200, 220, 30);
           txtName.setFont(new Font("SansSerif", Font.PLAIN, 16));
           add(txtName);


      // ================= Age =================

           JLabel lblAge = new JLabel("Age");
           lblAge.setBounds(320, 260, 120, 30);
           lblAge.setFont(new Font("SansSerif", Font.BOLD, 18));
           add(lblAge);
           txtAge = new JTextField();
           txtAge.setBounds(450, 260, 220, 30);
           txtAge.setFont(new Font("SansSerif", Font.PLAIN, 16));
           add(txtAge);

        // ================= Course =================

           JLabel lblCourse = new JLabel("Course");
           lblCourse.setBounds(320, 320, 120, 30);
           lblCourse.setFont(new Font("SansSerif", Font.BOLD, 18));
           add(lblCourse);

           String[] courses = {
                     "B.Tech CSE",
                     "B.Tech AIML",
                     "BCA",
                     "BBA",
                     "MBA"
           };

           cmbCourse = new JComboBox<>(courses);
           cmbCourse.setBounds(450, 320, 220, 30);
           add(cmbCourse);

         // ================= Year =================

         JLabel lblYear = new JLabel("Year");
         lblYear.setBounds(320, 380, 120, 30);
         lblYear.setFont(new Font("SansSerif", Font.BOLD, 18));
         add(lblYear);
         
         String[] years = {
                 "1st Year",
                 "2nd Year",
                 "3rd Year",
                 "4th Year"
         };

         cmbYear = new JComboBox<>(years);
         cmbYear.setBounds(450, 380, 220, 30);
         add(cmbYear);

         // ================= Gender =================

            JLabel lblGender = new JLabel("Gender");
           lblGender.setBounds(320, 440, 120, 30);
           lblGender.setFont(new Font("SansSerif", Font.BOLD, 18));
           add(lblGender);

           rbMale = new JRadioButton("Male");
           rbMale.setBounds(450, 440, 80, 30);
           rbMale.setBackground(Color.WHITE);
           add(rbMale);

           rbFemale = new JRadioButton("Female");
           rbFemale.setBounds(550, 440, 100, 30);
           rbFemale.setBackground(Color.WHITE);
           add(rbFemale);

           genderGroup = new ButtonGroup();
           genderGroup.add(rbMale);
           genderGroup.add(rbFemale);

        // ================= Save Button =================

           btnSave = new JButton("Save Student");
           btnSave.setBounds(320, 530, 160, 35);
           btnSave.setBackground(new Color(22,99,54));
           btnSave.setForeground(Color.WHITE);
           btnSave.addActionListener(this);
           add(btnSave);

         // ================= Back Button =================

         btnBack = new JButton("Back");
         btnBack.setBounds(510, 530, 120, 35);
         btnBack.setBackground(new Color(22,99,54));
         btnBack.setForeground(Color.WHITE);
         btnBack.addActionListener(this);
         add(btnBack);



    setSize(850, 650);
    setLocationRelativeTo(null);    
    setResizable(false);
    setTitle("Add Student");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == btnSave) {

        String id = txtStudentId.getText();
        String name = txtName.getText();
        String age = txtAge.getText();

        if (id.isEmpty() || name.isEmpty() || age.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please fill all the fields."
            );

            return;
        }

        try {

            int studentId = Integer.parseInt(id);
            int studentAge = Integer.parseInt(age);

            String course = (String) cmbCourse.getSelectedItem();
            String year = (String) cmbYear.getSelectedItem();

            String gender;

            if (rbMale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            Student student = new Student(
                    studentId,
                    name,
                    studentAge,
                    course,
                    year,
                    gender
            );

            manager.addStudent(student);

            JOptionPane.showMessageDialog(
                    null,
                    "Student Added Successfully!"
            );

            txtStudentId.setText("");
            txtName.setText("");
            txtAge.setText("");

            cmbCourse.setSelectedIndex(0);
            cmbYear.setSelectedIndex(0);

            genderGroup.clearSelection();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please enter valid numeric values."
            );

        }

    }

    else if (e.getSource() == btnBack) {

        setVisible(false);

        new Dashboard(manager);

    }

}

    public static void main(String[] args) {
      //   new AddStudent();
    //   new AddStudent(new StudentManager());
      StudentManager manager = new StudentManager();
       new AddStudent(manager);
    }
   
          
}

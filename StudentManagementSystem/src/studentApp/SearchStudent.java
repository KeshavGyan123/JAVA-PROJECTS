package StudentManagementSystem.src.studentApp;

// package studentApp;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;




public class SearchStudent extends JFrame  implements ActionListener{

// ================= Components =================

         JTextField txtStudentId;
          JButton btnSearch;
          JButton btnBack;
          JButton btnDelete;

// ================= Result Labels =================

        JLabel lblNameValue;
        JLabel lblAgeValue;
        JLabel lblCourseValue;
        JLabel lblYearValue;
        JLabel lblGenderValue;

// private StudentManager manager = new StudentManager();    
       private StudentManager manager;

    public SearchStudent(StudentManager manager) {
        this.manager = manager;

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

    JLabel heading = new JLabel("SEARCH STUDENT");
    heading.setBounds(220, 30, 350, 35);
    heading.setFont(new Font("SansSerif", Font.BOLD, 28));
    heading.setForeground(new Color(22,99,54));
    add(heading);


    JLabel lblStudentId = new JLabel("Student ID");
    // lblStudentId.setBounds(120, 120, 120, 30);
    lblStudentId.setBounds(100,120,130,30);
    lblStudentId.setFont(new Font("SansSerif", Font.BOLD, 18));
    add(lblStudentId);


    txtStudentId = new JTextField();
    txtStudentId.setBounds(250, 120, 220, 30);
    txtStudentId.setFont(new Font("SansSerif", Font.PLAIN, 16));
    add(txtStudentId);


    btnSearch = new JButton("Search");
    // btnSearch.setBounds(250, 180, 100, 35);
    btnSearch.setBounds(250,180,120,38);
    btnSearch.setBackground(new Color(22,99,54));
    btnSearch.setForeground(Color.WHITE);
    add(btnSearch);


    // btnBack = new JButton("Back");
    // btnBack.setBounds(370, 180, 100, 35);
    // btnBack.setBackground(new Color(22,99,54));
    // btnBack.setForeground(Color.WHITE);
    // add(btnBack);




    JLabel lblName = new JLabel("Name :");
    lblName.setBounds(120, 270, 100, 30);
    lblName.setFont(new Font("SansSerif", Font.BOLD, 18));
    add(lblName);
    lblNameValue = new JLabel("-");
    lblNameValue.setBounds(250, 270, 250, 30);
    lblNameValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
    add(lblNameValue);


    JLabel lblAge = new JLabel("Age :");
    lblAge.setBounds(120, 320, 100, 30);
    lblAge.setFont(new Font("SansSerif", Font.BOLD, 18));
    add(lblAge);
    lblAgeValue = new JLabel("-");
    lblAgeValue.setBounds(250, 320, 250, 30);
    lblAgeValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
    add(lblAgeValue);
 




    JLabel lblCourse = new JLabel("Course :");
    lblCourse.setBounds(120, 370, 100, 30);
    lblCourse.setFont(new Font("SansSerif", Font.BOLD, 18));
    add(lblCourse);
    lblCourseValue = new JLabel("-");
    lblCourseValue.setBounds(250, 370, 250, 30);
    lblCourseValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
    add(lblCourseValue);




JLabel lblYear = new JLabel("Year :");
lblYear.setBounds(120, 420, 100, 30);
lblYear.setFont(new Font("SansSerif", Font.BOLD, 18));
add(lblYear);
lblYearValue = new JLabel("-");
lblYearValue.setBounds(250, 420, 250, 30);
lblYearValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
add(lblYearValue);


JLabel lblGender = new JLabel("Gender :");
lblGender.setBounds(120, 470, 100, 30);
lblGender.setFont(new Font("SansSerif", Font.BOLD, 18));
add(lblGender);
lblGenderValue = new JLabel("-");
lblGenderValue.setBounds(250, 470, 250, 30);
lblGenderValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
add(lblGenderValue);



// ================= Delete Button =================

// btnDelete = new JButton("Delete Student");
// btnDelete.setBounds(220, 520, 170, 35);
// btnDelete.setBackground(new Color(22,99,54));
// btnDelete.setForeground(Color.WHITE);
// add(btnDelete);

// ================= Back Button =================

btnBack = new JButton("Back");
// btnBack.setBounds(420, 520, 120, 35);
btnBack.setBounds(315, 560, 120, 35);
btnBack.setBackground(new Color(22,99,54));
btnBack.setForeground(Color.WHITE);
add(btnBack);
System.out.println("Back button added");



// JLabel lblGender = new JLabel("Gender :");
// lblGender.setBounds(120, 470, 100, 30);
// lblGender.setFont(new Font("SansSerif", Font.BOLD, 18));
// add(lblGender);
// lblGenderValue = new JLabel("-");
// lblGenderValue.setBounds(250, 470, 250, 30);
// lblGenderValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
// add(lblGenderValue);


      btnSearch.addActionListener(this);
      txtStudentId.addActionListener(this);
      btnBack.addActionListener(this);



        // setSize(750, 650);
        setSize(750, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Search Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

        @Override
         public void actionPerformed(ActionEvent e) {

     if(e.getSource() == btnSearch || e.getSource() == txtStudentId) {

         String id = txtStudentId.getText();

        if (id.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter Student ID.");
            return;
        }

    try {

    int studentId = Integer.parseInt(id);

    Student student = manager.searchStudent(studentId);

    if (student != null) {

        lblNameValue.setText(student.getName());
        lblAgeValue.setText(String.valueOf(student.getAge()));
        lblCourseValue.setText(student.getCourse());
        lblYearValue.setText(student.getYear());
        lblGenderValue.setText(student.getGender());

        txtStudentId.setText("");
        txtStudentId.requestFocus();

    } else {

        clearStudentDetails();

        JOptionPane.showMessageDialog(
                null,
                "Student Not Found!"
        );
    }

} catch (NumberFormatException ex) {

    JOptionPane.showMessageDialog(
            null,
            "Please enter a valid Student ID."
    );

}
     }

    else if (e.getSource() == btnBack) {

        setVisible(false);
        new Dashboard(manager);
    }
}


      private void clearStudentDetails() {

        lblNameValue.setText("-");
        lblAgeValue.setText("-");
        lblCourseValue.setText("-");
        lblYearValue.setText("-");
        lblGenderValue.setText("-");
    }
    


    public static void main(String[] args) {

    StudentManager manager = new StudentManager();
    new SearchStudent(manager);

        // new SearchStudent();

    }
}
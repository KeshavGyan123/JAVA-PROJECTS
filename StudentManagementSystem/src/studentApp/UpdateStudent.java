package StudentManagementSystem.src.studentApp;
// package studentApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UpdateStudent extends JFrame implements ActionListener {


    // private StudentManager manager = new StudentManager();

    private StudentManager manager;


    // ================= Components =================

       JTextField txtStudentId; 
       JTextField txtName;
       JTextField txtAge;

       JComboBox<String> cmbCourse;
       JComboBox<String> cmbYear;

       JRadioButton rbMale;
       JRadioButton rbFemale;

       ButtonGroup genderGroup;

       JButton btnSearch;
       JButton btnUpdate;
       JButton btnBack;


    public UpdateStudent(StudentManager manager) {

        this.manager = manager;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


       // ================= Student ID =================

JLabel lblStudentId = new JLabel("Student ID");
lblStudentId.setBounds(120, 90, 120, 30);
lblStudentId.setFont(new Font("SansSerif", Font.BOLD, 18));
add(lblStudentId);
txtStudentId = new JTextField();
txtStudentId.setBounds(250, 90, 220, 30);
txtStudentId.setFont(new Font("SansSerif", Font.PLAIN, 16));
add(txtStudentId);

// ================= Search Button =================

btnSearch = new JButton("Search");
btnSearch.setBounds(500, 90, 120, 30);
btnSearch.setBackground(new Color(22,99,54));
btnSearch.setForeground(Color.WHITE);
add(btnSearch);



JLabel lblName = new JLabel("Name");
lblName.setBounds(120,170,120,30);
lblName.setFont(new Font("SansSerif",Font.BOLD,18));
add(lblName);
txtName = new JTextField();
txtName.setBounds(250,170,250,30);
txtName.setFont(new Font("SansSerif",Font.PLAIN,16));
add(txtName);


JLabel lblAge = new JLabel("Age");
lblAge.setBounds(120,220,120,30);
lblAge.setFont(new Font("SansSerif",Font.BOLD,18));
add(lblAge);

txtAge = new JTextField();
txtAge.setBounds(250,220,250,30);
txtAge.setFont(new Font("SansSerif",Font.PLAIN,16));
add(txtAge);




JLabel lblCourse = new JLabel("Course");
lblCourse.setBounds(120,270,120,30);
lblCourse.setFont(new Font("SansSerif",Font.BOLD,18));
add(lblCourse);

String[] courses = {
    "B.Tech CSE",
    "B.Tech AIML",
    "BCA",
    "BBA",
    "MBA"
};

cmbCourse = new JComboBox<>(courses);
cmbCourse.setBounds(250,270,250,30);
cmbCourse.setFont(new Font("SansSerif",Font.PLAIN,16));
add(cmbCourse);




JLabel lblYear = new JLabel("Year");
lblYear.setBounds(120,320,120,30);
lblYear.setFont(new Font("SansSerif",Font.BOLD,18));
add(lblYear);

String[] years = {
    "1st Year",
    "2nd Year",
    "3rd Year",
    "4th Year"
};

cmbYear = new JComboBox<>(years);
cmbYear.setBounds(250,320,250,30);
cmbYear.setFont(new Font("SansSerif",Font.PLAIN,16));
add(cmbYear);





JLabel lblGender = new JLabel("Gender");
lblGender.setBounds(120,370,120,30);
lblGender.setFont(new Font("SansSerif",Font.BOLD,18));

add(lblGender);

rbMale = new JRadioButton("Male");
rbMale.setBounds(250,370,80,30);
rbMale.setBackground(Color.WHITE);

add(rbMale);

rbFemale = new JRadioButton("Female");
rbFemale.setBounds(350,370,100,30);
rbFemale.setBackground(Color.WHITE);

add(rbFemale);

genderGroup = new ButtonGroup();
genderGroup.add(rbMale);
genderGroup.add(rbFemale);



// ================= Update Button =================

btnUpdate = new JButton("Update Student");
btnUpdate.setBounds(220,470,170,35);
btnUpdate.setBackground(new Color(22,99,54));
btnUpdate.setForeground(Color.WHITE);

add(btnUpdate);

// ================= Back Button =================

btnBack = new JButton("Back");
btnBack.setBounds(420,470,120,35);
btnBack.setBackground(new Color(22,99,54));
btnBack.setForeground(Color.WHITE);
add(btnBack);


btnSearch.addActionListener(this);
btnUpdate.addActionListener(this);
btnBack.addActionListener(this);

txtStudentId.addActionListener(this);



       JLabel heading = new JLabel("UPDATE STUDENT");
       heading.setBounds(250,20,350,35);
       heading.setFont(new Font("SansSerif",Font.BOLD,28));
       heading.setForeground(new Color(22,99,54));
       add(heading);



        setSize(850,650);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Update Student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enableForm(false);
        setVisible(true);

    }

@Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == btnSearch || e.getSource() == txtStudentId) {

        String id = txtStudentId.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter Student ID.");
            return;
        }

        try {

            int studentId = Integer.parseInt(id);

            Student student = manager.searchStudent(studentId);

            if (student != null) {

                txtName.setText(student.getName());
                txtAge.setText(String.valueOf(student.getAge()));
                cmbCourse.setSelectedItem(student.getCourse());
                cmbYear.setSelectedItem(student.getYear());

                if (student.getGender().equals("Male")) {
                    rbMale.setSelected(true);
                } else {
                    rbFemale.setSelected(true);
                }

                enableForm(true);

            } else {

                clearForm();
                enableForm(false);

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

    else if (e.getSource() == btnUpdate) {

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

            Student student = manager.searchStudent(studentId);

            if (student != null) {

                student.setName(name);
                student.setAge(studentAge);
                student.setCourse(course);
                student.setYear(year);
                student.setGender(gender);

                JOptionPane.showMessageDialog(
                        null,
                        "Student Updated Successfully!"
                );

                clearForm();
                enableForm(false);

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Student Not Found!"
                );

            }

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


private void enableForm(boolean status){
    txtName.setEnabled(status);
    txtAge.setEnabled(status);
    cmbCourse.setEnabled(status);
    cmbYear.setEnabled(status);
    rbMale.setEnabled(status);
    rbFemale.setEnabled(status);
    btnUpdate.setEnabled(status);}


    private void clearForm() {
    txtStudentId.setText("");
    txtName.setText("");
    txtAge.setText("");
    cmbCourse.setSelectedIndex(0);
    cmbYear.setSelectedIndex(0);
    genderGroup.clearSelection();
    txtStudentId.requestFocus();

}


    public static void main(String[] args) {
      StudentManager manager = new StudentManager();
        new UpdateStudent(manager);

    }

}




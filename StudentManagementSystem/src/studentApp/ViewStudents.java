package StudentManagementSystem.src.studentApp;

// package studentApp;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ViewStudents extends JFrame implements ActionListener  {

    
        // ================= Table =================

            JTable table;
            DefaultTableModel model;

            JButton btnBack;

        // private StudentManager manager = new StudentManager();
        private StudentManager manager;



  public ViewStudents(StudentManager manager) {

    this.manager = manager;



        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW STUDENTS");
        heading.setBounds(320, 20, 350, 35);
        heading.setFont(new Font("SansSerif", Font.BOLD, 28));
        heading.setForeground(new Color(22,99,54));
        add(heading);


        String[] columns = {
                           "ID",
                           "Name",
                            "Age",
                            "Course",
                            "Year",
                            "Gender"
                                    };

        model = new DefaultTableModel(columns, 0);


        // table = new JTable(model);
          table = new JTable(model){

        
            
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
};


        table.setRowHeight(30);
        table.setFont(new Font("SansSerif", Font.PLAIN, 16));
        table.getTableHeader().setFont(
        new Font("SansSerif", Font.BOLD, 16)
        );

        table.getTableHeader().setPreferredSize(
        new Dimension(100, 35));



        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 80, 880, 480);
        add(scrollPane);


    table.addMouseListener(new MouseAdapter() {

    @Override
        public void mouseClicked(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        System.out.println("Selected Row: " + selectedRow);
    }
});

       // ================= Back Button =================

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 580, 120, 35);
        btnBack.setBackground(new Color(22,99,54));
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        add(btnBack);

        loadStudents();      //  used for calling. (bookmark)
       

        setSize(950,650);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("View Students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
        @Override
        public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
        setVisible(false);
        new Dashboard(manager);

    }

}

        private void loadStudents() {
            model.setRowCount(0);
            
        if (manager.getAllStudents().isEmpty()) {
        JOptionPane.showMessageDialog(null,"No students available.");

    return;
}

        for (Student student : manager.getAllStudents()) {
        model.addRow(new Object[]{
        student.getStudentId(),
        student.getName(),
        student.getAge(),
        student.getCourse(),
        student.getYear(),
        student.getGender()
    });
       }

        }


    public static void main(String[] args) {
        // new ViewStudents();
        StudentManager manager = new StudentManager();
        new ViewStudents(new StudentManager());

    }

}
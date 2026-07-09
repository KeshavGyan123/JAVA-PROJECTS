// package studentApp;

package StudentManagementSystem.src.studentApp;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
// import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame  implements ActionListener{ 
  
    JButton loginButton, exitButton;

    Login(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        // System.out.println(ClassLoader.getSystemResource("icons/welcome.png"));
        // System.out.println(System.getProperty("user.dir"));

        String path = "StudentManagementSystem/src/studentApp/icons/welcome.png";
        System.out.println(new java.io.File(path).exists());
        ImageIcon i1 = new ImageIcon(path);



//************************************************************************************
        // String path = "src/studentApp/icons/welcome.png";
        // System.out.println(new java.io.File(path).getAbsolutePath());
        // System.out.println(new java.io.File(path).exists());
//************************************************************************************
        //  ImageIcon i1 = new ImageIcon(path);

        //  ImageIcon i1 = new ImageIcon(
        //  Login.class.getResource("/icons/welcome.png")
// );

        //   ImageIcon i1 = new ImageIcon("StudentManagementSystem/src/studentApp/icons/welcome.png");  noted one 


        // ImageIcon i1 = new ImageIcon("src/studentApp/icons/welcome.png");

//         ImageIcon i1 = new ImageIcon(
//     Login.class.getResource("/studentApp/icons/welcome.png")
// ); 

        // ImageIcon i1 = new ImageIcon("StudentManagementSystem/icons/welcome.png");

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.png"));
        Image i2 = i1.getImage().getScaledInstance(420, 420, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(40, 60, 420, 420);
        add(image);

        JLabel heading = new JLabel("STUDENT MANAGEMENT");

        heading.setBounds(520, 70, 450, 40);
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);
       
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(520, 150, 120, 15);
        userLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(userLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(520, 180, 280, 35);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 16)); 
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(520, 240, 120, 25);
        passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(520, 270, 280, 35);
        passwordField.setFont(new Font ("SansSerif", Font.PLAIN, 16));
        add(passwordField);
   
        loginButton = new JButton("Login");
        loginButton.setBounds(520, 340, 120, 35);
        loginButton.setBackground(new Color(22, 99, 54));
        loginButton.setForeground(Color.WHITE);
        // loginButton.setFocusPainted(false);
        add(loginButton);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(680, 340, 120, 35);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(this);
        add(exitButton);


        setSize(1000, 550);
         
        // setLocationRelativeTo(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
        setVisible(false);

        StudentManager manager = new StudentManager();

        new Dashboard(manager);}

    // new Dashboard();

// }
//        else if(e.getSource() == btnBack){

//     setVisible(false);

//     new Dashboard(manager);

// }
          else if(e.getSource() == exitButton){

        System.exit(0);

    }

    }


    public static void main(String[] args) {
        new Login();
        
    }

}



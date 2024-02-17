package course.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;



public class CreateAccount extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField phoneField;
    private JComboBox<String> rolesComboBox;
    private JComboBox<String> courseComboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateAccount frame = new CreateAccount();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CreateAccount() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 825, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setForeground(new Color(164, 201, 58));
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        
        usernameField = new JTextField();
        usernameField.setToolTipText("");
        usernameField.setColumns(10);
        usernameField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        emailField = new JTextField();
        emailField.setToolTipText("");
        emailField.setColumns(10);
        emailField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        passwordField = new JPasswordField();
        passwordField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        phoneField = new JTextField();
        phoneField.setToolTipText("");
        phoneField.setColumns(10);
        phoneField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));

        rolesComboBox = new JComboBox<>(new String[]{"Student", "Instructor"});
        rolesComboBox.setForeground(Color.BLACK);
        rolesComboBox.setFont(new Font("Poppins", Font.PLAIN, 14));
        rolesComboBox.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        rolesComboBox.setBackground(new Color(248, 248, 248));

//        Courses c = new Courses();
//        courseComboBox = new JComboBox<>(c.getCourseNames());
//        courseComboBox.setForeground(Color.BLACK);
//        courseComboBox.setFont(new Font("Poppins", Font.PLAIN, 14));
//        courseComboBox.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
//        courseComboBox.setBackground(new Color(248, 248, 248));

        JButton createButton = new JButton("Create");
        createButton.setBounds(100, 100, 200, 50);
        createButton.setForeground(new Color(248, 248, 248));
        createButton.setFont(new Font("Poppins", Font.PLAIN, 16));
        createButton.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        createButton.setBackground(new Color(117, 191, 67));
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(usernameField)
                    .addComponent(emailField)
                    .addComponent(passwordField)
                    .addComponent(phoneField)
                    .addComponent(rolesComboBox)
                    .addComponent(courseComboBox)
                    .addComponent(createButton)
                )
            )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addComponent(usernameField)
                .addComponent(emailField)
                .addComponent(passwordField)
                .addComponent(phoneField)
                .addComponent(rolesComboBox)
                .addComponent(courseComboBox)
                .addComponent(createButton)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void createAccount() {
        String uname = usernameField.getText();
        String p = new String(passwordField.getPassword());
        String em = emailField.getText();
        String ph = phoneField.getText();
        String selectedRole = rolesComboBox.getSelectedItem().toString();
        int courseId = -1; // default value for teacher
        if (selectedRole.equals("Student")) {
            courseId = courseComboBox.getSelectedIndex() + 1; // Index is zero-based
        }
//        Validation v = new Validation();
//        Student s = new Student();
//        Instructor i = new Instructor();
//        Courses c = new Courses();
//        try {
//            if (v.emailCheck(em) && v.phoneCheck(ph) && v.passCheck(p)) {
//                if (selectedRole.equals("Student")) {
//                    s.studentRegister(uname, courseId, em, p, ph, 1);
//                } else {
//                    i.addInstructor(uname, em, ph, p);
//                }
//            }
//        } catch (NullValueException ex) {
//            JOptionPane.showMessageDialog(null, "Please fill all the fields");
//        } catch (InvalidFormatException ex1) {
//            JOptionPane.showMessageDialog(null, "Invalid Email or Phone Number or Password Format");
//        }
    }
}

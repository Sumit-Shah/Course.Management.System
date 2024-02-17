package course.management.system;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JButton loginButton, cancelButton;
    private JTextField usernameField, passwordField;
    private JComboBox selectMode;

    public Login() {
    	getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
    	getContentPane().setForeground(new Color(255, 255, 255));
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(128, 255, 128));
        getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsername.setBounds(81, 20, 100, 20);
        getContentPane().add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(242, 20, 150, 20);
        getContentPane().add(usernameField);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPassword.setBounds(81, 70, 100, 20);
        getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(242, 70, 150, 20);
        getContentPane().add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(87, 140, 120, 30);
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.addActionListener(this);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 19));
        getContentPane().add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(272, 140, 120, 30);
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setForeground(new Color(0, 0, 0));
        cancelButton.addActionListener(this);
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 19));
        getContentPane().add(cancelButton);
        
        selectMode = new JComboBox();
        selectMode.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student", "Teacher"}));
        selectMode.setBounds(242, 107, 150, 22);
        getContentPane().add(selectMode);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String loginMode = selectMode.getSelectedItem().toString();
            
            switch(loginMode) {
            case "Admin":
            	String query = "select * from admin where username='" + username + "' and password='" + password + "'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    
                    if (rs.next()) {
                        setVisible(false);
                        new Project();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                        setVisible(false);
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
            
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}

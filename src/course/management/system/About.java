package course.management.system;


import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(128, 255, 128));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        getContentPane().add(image);
        
        JLabel heading = new JLabel("<html>Course<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        getContentPane().add(heading);
        
        JLabel name = new JLabel("Developed By: SUMIT SHAH");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(name);
        
        JLabel rollno = new JLabel("Roll number: 1533146");
        rollno.setBounds(70, 280, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(rollno);
        
        JLabel contact = new JLabel("Email: np03cs4s230083@heraldcollege.edu.np");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 21));
        getContentPane().add(contact);
        
        getContentPane().setLayout(null);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
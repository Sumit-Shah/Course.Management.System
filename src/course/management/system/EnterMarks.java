package course.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2,tfsub3,tfsub4,tfmarks1,tfmarks2,tfmarks3,tfmarks4;
    JButton cancel, submit;
    
    EnterMarks() {
        
        setSize(1000, 500);
        setLocation(300, 150);
        getContentPane().setLayout(null);
        
        getContentPane().setBackground(new Color(128, 255, 128));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        getContentPane().add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBackground(new Color(128, 255, 128));
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        getContentPane().add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblrollnumber.setBounds(50, 70, 150, 20);
        getContentPane().add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        getContentPane().add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsemester.setBounds(50, 110, 150, 20);
        getContentPane().add(lblsemester);
        
        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        cbsemester = new JComboBox(semester);
        cbsemester.setFont(new Font("Tahoma", Font.BOLD, 12));
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        getContentPane().add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblentersubject.setBounds(100, 150, 200, 40);
        getContentPane().add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblentermarks.setBounds(320, 150, 200, 40);
        getContentPane().add(lblentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 200, 200, 20);
        getContentPane().add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 20);
        getContentPane().add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 260, 200, 20);
        getContentPane().add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 290, 200, 20);
        getContentPane().add(tfsub4);
        
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 200, 200, 20);
        getContentPane().add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 230, 200, 20);
        getContentPane().add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 260, 200, 20);
        getContentPane().add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 290, 200, 20);
        getContentPane().add(tfmarks4);
        

        
        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(new Color(255, 255, 255));
        submit.setForeground(new Color(0, 0, 0));
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 19));
        getContentPane().add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(new Color(255, 255, 255));
        cancel.setForeground(new Color(0, 0, 0));
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 19));
        getContentPane().add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                
                String query1 = "INSERT INTO subject (rollno, semester, subject1, subject2, subject3, subject4) " +
                        "VALUES ('" + crollno.getSelectedItem() + "', '" + cbsemester.getSelectedItem() + "', '" +
                        tfsub1.getText() + "', '" + tfsub2.getText() + "', '" + tfsub3.getText() + "', '" +
                        tfsub4.getText() + "')";
                
                String query2 = "INSERT INTO marks (rollno, semester, marks1, marks2, marks3, marks4) " +
                        "VALUES ('" + crollno.getSelectedItem() + "', '" + cbsemester.getSelectedItem() + "', '" +
                        tfmarks1.getText() + "', '" + tfmarks2.getText() + "', '" + tfmarks3.getText() + "', '" +
                        tfmarks4.getText() + "')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}

package course.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
    	setBackground(new Color(0, 255, 0));
        setSize(1540, 850);
               ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));       Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);       ImageIcon i3 = new ImageIcon(i2);       JLabel image = new JLabel(i3);
       image.setFont(new Font("Tahoma", Font.BOLD, 13));
       image.setBackground(new Color(0, 255, 0));       getContentPane().add(image, BorderLayout.NORTH);     
        JMenuBar mb = new JMenuBar();
        
        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setFont(new Font("Segoe UI", Font.BOLD, 13));
        newInformation.setBackground(new Color(0, 255, 0));
        newInformation.setForeground(new Color(0, 0, 0));
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        // Details
        JMenu details = new JMenu("View Details");
        details.setFont(new Font("Segoe UI", Font.BOLD, 13));
        details.setBackground(new Color(0, 255, 0));
        details.setForeground(new Color(0, 0, 0));
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setFont(new Font("Segoe UI", Font.BOLD, 12));
        facultydetails.setForeground(new Color(0, 0, 0));
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setFont(new Font("Segoe UI", Font.BOLD, 12));
        studentdetails.setForeground(new Color(0, 0, 0));
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setFont(new Font("Segoe UI", Font.BOLD, 13));
        exam.setBackground(new Color(0, 255, 0));
        exam.setForeground(new Color(0, 0, 0));
        mb.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setFont(new Font("Segoe UI", Font.BOLD, 12));
        examinationdetails.setForeground(new Color(0, 0, 0));
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setFont(new Font("Segoe UI", Font.BOLD, 12));
        entermarks.setForeground(new Color(0, 0, 0));
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        updateInfo.setBackground(new Color(0, 255, 0));
        updateInfo.setForeground(new Color(0, 0, 0));
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        updatefacultyinfo.setForeground(new Color(0, 0, 0));
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        updatestudentinfo.setForeground(new Color(0, 0, 0));
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Segoe UI", Font.BOLD, 13));
        utility.setBackground(new Color(0, 255, 0));
        utility.setForeground(new Color(0, 0, 0));
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("Segoe UI", Font.BOLD, 12));
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        // about
        JMenu about = new JMenu("About");
        about.setFont(new Font("Segoe UI", Font.BOLD, 13));
        about.setBackground(new Color(0, 255, 0));
        about.setForeground(new Color(0, 0, 0));
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        // exit
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
        exit.setBackground(new Color(0, 255, 0));
        exit.setForeground(new Color(0, 0, 0));
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}

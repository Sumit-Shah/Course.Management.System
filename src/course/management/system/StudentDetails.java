package course.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails() {
        
        getContentPane().setBackground(new Color(128, 255, 128));
        getContentPane().setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        heading.setBounds(37, 20, 196, 29);
        getContentPane().add(heading);
        
        crollno = new Choice();
        crollno.setBounds(250, 20, 150, 20);
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
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        getContentPane().add(jsp);
        
        search = new JButton("Search");
        search.setFont(new Font("Tahoma", Font.BOLD, 13));
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        getContentPane().add(search);
        
        print = new JButton("Print");
        print.setFont(new Font("Tahoma", Font.BOLD, 13));
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        getContentPane().add(print);
        
        add = new JButton("Add");
        add.setFont(new Font("Tahoma", Font.BOLD, 13));
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        getContentPane().add(add);
        
        update = new JButton("Update");
        update.setFont(new Font("Tahoma", Font.BOLD, 13));
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        getContentPane().add(update);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Tahoma", Font.BOLD, 13));
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        getContentPane().add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
//            new UpdateStudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}

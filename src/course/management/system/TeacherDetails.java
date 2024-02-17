package course.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, cancel;
    
    TeacherDetails() {
        
        getContentPane().setBackground(new Color(128, 255, 128));
        getContentPane().setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        heading.setBounds(20, 11, 203, 29);
        getContentPane().add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(250, 20, 150, 20);
        getContentPane().add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
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
            String query = "select * from teacher where rollno = '"+cEmpId.getSelectedItem()+"'";
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
            new AddTeacher();
        } else if (ae.getSource() == update) {
            setVisible(false);
//            new UpdateTeacher();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}

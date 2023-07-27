
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{


        JTable table;
        JButton  back ;
        
        ManagerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel h1  = new JLabel("Name");
        h1.setBounds(40,10,100,20);
        add(h1);
        
        JLabel h2  = new JLabel("Age");
        h2.setBounds(170,10,100,20);
        add(h2);
        
        JLabel h3  = new JLabel("Gender");
        h3.setBounds(300,10,100,20);
        add(h3);
        
        JLabel h4  = new JLabel("Job");
        h4.setBounds(400,10,100,20);
        add(h4);
        
        JLabel h5  = new JLabel("Salary");
        h5.setBounds(540,10,100,20);
        add(h5);
        
        JLabel h6  = new JLabel("Phone");
        h6.setBounds(670,10,100,20);
        add(h6);
        
        JLabel h7  = new JLabel("Email");
        h7.setBounds(790,10,100,20);
        add(h7);
        
        JLabel h8  = new JLabel("Aadhar");
        h8.setBounds(910,10,100,20);
        add(h8);
        
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs  = c.s.executeQuery("Select * from employee where job = 'manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                            // or
            /*conn con = new conn();
               String query  = "Select * from room";
              ResultSet rs  =  con.s.executeQuery(query);        
            */                    
        }
        catch(Exception e){
        
            e.printStackTrace();
            
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(300,200,1000,600);
        setVisible(true); 


        } 
        
         public void actionPerformed(ActionEvent ae){
     
          setVisible(false);
          new Reception(); 
     
        }
          
        public static void main(String args[]){
        
           new ManagerInfo();
        } 
    
}

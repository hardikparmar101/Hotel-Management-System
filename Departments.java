
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Departments extends JFrame implements ActionListener{

       JTable table;
       JButton  back ;
       
    Departments(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel h1  = new JLabel("Departments");
        h1.setFont(new Font("Tahoma",Font.BOLD,15));
        h1.setBounds(250,10,120,20);
        add(h1);
        
        JLabel h2  = new JLabel("budget");
        h2.setBounds(750,10,100,20);
        h2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(h2);
        
        
        table  = new JTable();
        table.setBounds(0,40,1059,400);
        add(table);
        
        
        try{
        
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        
        }
        catch(Exception e){
        
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(400,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(300,200,1050,600);
        setVisible(true); 
    
    }
     public void actionPerformed(ActionEvent ae){
     
          setVisible(false);
          new Reception(); 
     
     }
     
    public static void main(String args[]){
        
        new Departments();
    }
    
    
     
      
 
    
}

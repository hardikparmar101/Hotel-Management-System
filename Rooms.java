package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{

        JTable table;
        JButton  back ;
        
    Rooms(){
        
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2      = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel h1  = new JLabel("Room Number");
        h1.setBounds(10,10,100,20);
        add(h1);
        
        JLabel h2  = new JLabel("Availabity");
        h2.setBounds(120,10,100,20);
        add(h2);
        
        JLabel h3  = new JLabel("Status");
        h3.setBounds(220,10,100,20);
        add(h3);
        
        JLabel h4  = new JLabel("Price");
        h4.setBounds(320,10,100,20);
        add(h4);
        
        JLabel h5  = new JLabel("Bed Type");
        h5.setBounds(420,10,100,20);
        add(h5);
        
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs  = c.s.executeQuery("Select * from room");
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
        back.setBounds(200,500,120,30);
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
        
        new Rooms();
    }
    
    
    
}



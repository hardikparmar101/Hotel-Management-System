package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;  // for creating a table 

public class SearchRooms extends JFrame implements ActionListener{

        JTable table;
        JButton  back , submit;
        JComboBox bedType ; 
        JCheckBox available ; 
        
    SearchRooms(){
        
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel  searchRoom  = new JLabel("Search for Rooms");
        searchRoom.setBounds(400,30,200,30);
        searchRoom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(searchRoom);
        
        JLabel searchBed  = new JLabel("Bed Type");
        searchBed.setBounds(50,100,100,20);
        add(searchBed);
        
        bedType  = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available  = new JCheckBox("Only Dispaly Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        JLabel h1  = new JLabel("Room Number");
        h1.setBounds(10,180,100,20);
        add(h1);
        
        JLabel h2  = new JLabel("Availabity");
        h2.setBounds(270,180,100,20);
        add(h2);
        
        JLabel h3  = new JLabel("Status");
        h3.setBounds(470,180,100,20);
        add(h3);
        
        JLabel h4  = new JLabel("Price");
        h4.setBounds(670,180,100,20);
        add(h4);
        
        JLabel h5  = new JLabel("Bed Type");
        h5.setBounds(850,180,100,20);
        add(h5);
        
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
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
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(300,200,1000,600);
        setVisible(true); 
    
    }
    
     public void actionPerformed(ActionEvent ae){
     
         if(ae.getSource() == submit){
         
             try{
                 
                 String query1 = "Select * from room Where roomType = '"+bedType.getSelectedItem()+"' ";
                 String query2 = "Select * from room Where Availability = 'Available' AND roomType =  '"+bedType.getSelectedItem()+"' ";
                 
                 Conn con = new Conn();
                 ResultSet rs ; 
                 
                 if(available.isSelected()){                   
                     rs  = con.s.executeQuery(query2);
                 }
                 else{
                     rs = con.s.executeQuery(query1);
                 }
                  table.setModel(DbUtils.resultSetToTableModel(rs));
                 
             }
             catch(Exception e){
                 
                 e.printStackTrace();
             }
             
         }
         else{
             
             setVisible(false);
            new Reception(); 
         }
         
          
     
     }




    
    public static void main(String args[]){
        
        new SearchRooms();
    }
    
    
    
}



package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AddRooms extends JFrame implements  ActionListener{

    JButton add , Cancel ;
    JTextField txt1 , txt2 ; 
    JComboBox  AvailableCombox ,CleanCombox ,bedCombox ; 
    AddRooms(){
        
        
     getContentPane().setBackground(Color.WHITE);    
     setLayout(null);
      
     JLabel heading = new JLabel("Add Rooms");
     heading.setFont(new Font("Tahoma",Font.BOLD,18));
     heading.setBounds(150,20,200,20);
     add(heading);
     
     JLabel lblroomNo = new JLabel("Rooms Number");
     lblroomNo.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblroomNo.setBounds(60,80,200,20);
     add(lblroomNo);
     
     txt1  = new JTextField();
     txt1.setBounds(200,80,150,30);
     add(txt1);
     
     JLabel lblAvailable = new JLabel("Available");
     lblAvailable.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblAvailable.setBounds(60,130,120,30);
     add(lblAvailable);
     
     String AvailableOption[] =     {"Available","Occupied"};
     AvailableCombox    =  new   JComboBox(AvailableOption);
     AvailableCombox.setBounds(200,130, 150 ,30);
     AvailableCombox.setBackground(Color.WHITE);
     add(AvailableCombox);
     
     
     JLabel lblAClean = new JLabel("Cleaning Status");
     lblAClean.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblAClean.setBounds(60,180,200,30);
     add(lblAClean);
     
     String CleanOption[] =     {"Cleaned","Dirty"};
     CleanCombox    =  new   JComboBox(CleanOption);
     CleanCombox.setBounds(200,180, 150 ,30);
     CleanCombox.setBackground(Color.WHITE);
     add(CleanCombox);
     
     JLabel lblPrice = new JLabel("Price");
     lblPrice.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblPrice.setBounds(60,230,200,30);
     add(lblPrice);
     
     txt2  = new JTextField();
     txt2.setBounds(200,230,150,30);
     add(txt2);
     
      JLabel lblType = new JLabel("Bed Type");
     lblType.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblType.setBounds(60,280,120,30);
     add(lblType);
     
     String bedOption[] =     {"Single Bed","Double Bed"};
     bedCombox    =  new   JComboBox(bedOption);
     bedCombox.setBounds(200,280, 150 ,30);
     bedCombox.setBackground(Color.WHITE);
     add(bedCombox);
     
     
     add  =  new JButton("Add Room");
     add.addActionListener(this);
     add.setForeground(Color.WHITE);
     add.setBackground(Color.BLACK);
     add.setBounds(60,350,130,30);
     add(add);
     
     Cancel  =  new JButton("Cancel");
     Cancel.addActionListener(this);
     Cancel.setForeground(Color.WHITE);
     Cancel.setBackground(Color.BLACK);
     Cancel.setBounds(220,350,130,30);
     add(Cancel);
     
     ImageIcon ImgIcn   =  new  ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
     JLabel  Imglb   = new JLabel(ImgIcn);
     Imglb.setBounds(400,30,500,300);
     add(Imglb);
     
    
     
    setBounds(330,200,940,470);
    setVisible(true);
           
    }
    
    public void actionPerformed(ActionEvent ac){
              
        //JOptionPane.showMessageDialog(null,"New room Add Successfully");
            
        if(ac.getSource() == add){
            
            String roomNo = txt1.getText();
            String Availability   = (String)  AvailableCombox.getSelectedItem();
            String Status         = (String) CleanCombox.getSelectedItem();
            String price          =  txt2.getText();
            String rtype          = (String) bedCombox.getSelectedItem();
             
            try{
                   Conn c = new Conn();
                  String query   = "insert into room values('"+roomNo+"' ,'"+Availability+"' , '"+Status+"' , '"+price+"' ,'"+rtype+" ' )";
                
                  c.s.executeUpdate(query);  
                  
                  JOptionPane.showMessageDialog(null,"New room Add Successfully");
                  setVisible(false);
            }
            catch(Exception e){
                
                e.printStackTrace();
            }
           
        }
        
         else if(ac.getSource() == Cancel){
                this.setVisible(false);
            }
        
    }
    
    public static void main(String args[]){
        
         new AddRooms().setVisible(true);
        
    }


    
}

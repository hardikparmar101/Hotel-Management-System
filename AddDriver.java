package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class AddDriver extends JFrame implements  ActionListener{

    JButton add , Cancel ;
    JTextField txt1 , txt2,txt3 , txt4 , txt5 ; 
    JComboBox   GenderCombox,carTypeCombox,AvailableCombox; 
    
    AddDriver(){
          
     getContentPane().setBackground(Color.WHITE);    
     setLayout(null);
      
     JLabel heading = new JLabel("Add Driver");
     heading.setFont(new Font("Tahoma",Font.BOLD,18));
     heading.setBounds(150,10,200,20);
     add(heading);
     
     JLabel lblName = new JLabel("Name");
     lblName.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblName.setBounds(60,70,200,20);
     add(lblName);
     
     txt1  = new JTextField();
     txt1.setBounds(200,70,150,30);
     add(txt1);
     //start Age
     JLabel lblAge = new JLabel("Age");
     lblAge.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblAge.setBounds(60,120,120,30);
     add(lblAge);
     
     txt2  = new JTextField();
     txt2.setBounds(200,120,150,30);
     add(txt2);
     //end Age
     
     //start  gender
     JLabel lblGender = new JLabel("Gender");
     lblGender.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblGender.setBounds(60,170,200,30);
     add(lblGender);
     
     String CleanOption[] =     {"Male","Female"};
     GenderCombox    =  new   JComboBox(CleanOption);
     GenderCombox.setBounds(200,170, 150 ,30);
     GenderCombox.setBackground(Color.WHITE);
     add(GenderCombox);
     //end gender
     
     //start car Comapany
     JLabel lblCarComp = new JLabel("Car Company");
     lblCarComp.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblCarComp.setBounds(60,220,200,30);
     add(lblCarComp);
     
     txt3  = new JTextField();
     txt3.setBounds(200,220,150,30);
     add(txt3);
     //end
     //start
     JLabel lblType = new JLabel("Car Models");
     lblType.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblType.setBounds(60,270,120,30);
     add(lblType);
     
      txt4  = new JTextField();
     txt4.setBounds(200,270,150,30);
     add(txt4);
     
     /*String bedOption[] = {"Toyota Fortuner","Jeep","Hyundai Venue","Mahindra Thar","BMW 3 Series","Mahindra Scorpio"};
     carTypeCombox    =  new   JComboBox(bedOption);
     carTypeCombox.setBounds(200,280, 150 ,30);
     carTypeCombox.setBackground(Color.WHITE);
     add(carTypeCombox);
     */
     //end
     
      JLabel lblAvailable = new JLabel("Available");
     lblAvailable.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblAvailable.setBounds(60,320,120,30);
     add(lblAvailable);
     
     String DriverOption[] = {"Available","Not Available"};
     AvailableCombox    =  new   JComboBox(DriverOption);
     AvailableCombox.setBounds(200,320, 150 ,30);
     AvailableCombox.setBackground(Color.WHITE);
     add(AvailableCombox);
     
     JLabel lblLocation = new JLabel("Location");
     lblLocation.setFont(new Font("Tahoma",Font.PLAIN,18));
     lblLocation.setBounds(60,370,120,30);
     add(lblLocation);
     
      txt5  = new JTextField();
     txt5.setBounds(200,370,150,30);
     add(txt5);
     
     add  =  new JButton("Add Driver");
     add.addActionListener(this);
     add.setForeground(Color.WHITE);
     add.setBackground(Color.BLACK);
     add.setBounds(60,415,130,30);
     add(add);
     
     Cancel  =  new JButton("Cancel");
     Cancel.addActionListener(this);
     Cancel.setForeground(Color.WHITE);
     Cancel.setBackground(Color.BLACK);
     Cancel.setBounds(220,415,130,30);
     add(Cancel);
     
     ImageIcon ImgIcn   =  new  ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
     Image i2           = ImgIcn.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT); // for image proper look
     ImageIcon i3       =   new ImageIcon(i2);
     JLabel  Imglb   = new JLabel(i3);
     Imglb.setBounds(400,30,500,300);
     add(Imglb);
      
    setBounds(300,200,980,470);
    setVisible(true);
           
    }
    
    public void actionPerformed(ActionEvent ac){
              
        //JOptionPane.showMessageDialog(null,"New room Add Successfully");
            
        if(ac.getSource() == add){
            
            String name = txt1.getText();
            String age  = txt2.getText();
            String gender   = (String)  GenderCombox.getSelectedItem();
            String carCompany = txt3.getText();
            String carModel   = txt4.getText();
            String Available         = (String) AvailableCombox.getSelectedItem();
            String location          =  txt5.getText();
            
             
            try{
                  Conn c = new Conn();
                  String query   = "insert into driver values('"+name+"' ,'"+age+"' , '"+gender+"' , '"+carCompany+"' ,'"+carModel+"' ,  '"+Available+"' ,'"+location+" ' )";
                   //String query   = "insert into room values('"+roomNo+"' ,'"+Availability+"' , '"+Status+"' , '"+price+"' ,'"+rtype+" ' )";
                  c.s.executeUpdate(query);  
                  
                  JOptionPane.showMessageDialog(null,"New Driver Add Successfully");
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
         new AddDriver().setVisible(true);
    }

}

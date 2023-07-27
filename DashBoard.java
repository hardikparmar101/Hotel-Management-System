package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DashBoard  extends JFrame implements ActionListener {

        DashBoard(){
            
            setBounds(0,0,1450,1000);
            
            setLayout(null);  
            ImageIcon il =  new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
            Image i2   = il.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel img   = new JLabel(i3);
            img.setBounds(0,0,1550,1000);
            add(img);
            
            JLabel txt1  =   new JLabel("HOTEL RAJ PLACE WLECOMES YOU");
            txt1.setBounds(300, 80, 1000, 50);
            txt1.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,46));
            txt1.setForeground(Color.WHITE);
            img.add(txt1);
            
            JMenuBar mb  = new JMenuBar(); // for menu bar
            mb.setBounds(0,0,1550,30);
            //mb.setForeground(Color.BLACK);
            img.add(mb);
            
            JMenu  hotel = new JMenu("Hotel Management");  // menu bar item; 
            hotel.setForeground(Color.RED);
            mb.add(hotel);
               
            JMenuItem Reception = new JMenuItem("Reception");
            Reception.addActionListener(this);
            hotel.add(Reception);
             
            JMenu  Admin = new JMenu("Admin");  // menu bar item ; 
            Admin.setForeground(Color.BLUE);
            mb.add(Admin);
            // Admin list item 
            JMenuItem addEmp  = new JMenuItem("Add Employees");
            addEmp.addActionListener(this);
            Admin.add(addEmp);
            
            
            JMenuItem addRooms  = new JMenuItem("Add Rooms");
            addRooms.addActionListener(this);
            Admin.add(addRooms);
            
            JMenuItem addDrivers  = new JMenuItem("Add Drivers");
            addDrivers.addActionListener(this);
            Admin.add(addDrivers);
            
            
            
            
            setVisible(true);
           
        } 
        
        
       public void actionPerformed(ActionEvent ac){
           
          if(ac.getActionCommand().equals("Add Employees")){
           
                new AddEmployee();
          } 
          else if(ac.getActionCommand().equals("Add Rooms")){
              new AddRooms(); 
          }
          else if(ac.getActionCommand().equals("Add Drivers")){
              new AddDriver();
          }
          else if(ac.getActionCommand().equals("Reception")){
              new Reception();
          }
              
       }
        
        public static void main(String args[]){
            DashBoard dashBoard = new DashBoard(); 
        }
}

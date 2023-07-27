package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        
        setSize(1366, 565);
        setLocation(100,100);
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image  = new JLabel(i1);
        image.setBounds(0,0 ,1366, 565); //location x ,locY, length, breadth(setbounds for set layout )                                    
        add(image);
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50)); // "font family" , font type,size 
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.white);
        next.setForeground(Color.blue);
        next.addActionListener(this); 
        next.setFont(new Font("serif",Font.PLAIN,26));
        image.add(next); 
        
        setVisible(true);
        //wihle loop for blinking of hotel Managenment System Name on image 
      while(true){
          
          text.setVisible(false);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){
              e.printStackTrace();
          }
          text.setVisible(true);
           try{
              Thread.sleep(500);
          }
          catch(Exception e){
              e.printStackTrace();
          }
      }
      
    } 
        
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);  // current window close ; 
        new Login();   //    (obj of login cunstrcter)  calling login ka cunstrcater
        // this method for action Event ; (override , abstract method calling)
    }
    
    public static void main(String[] args) {
     
        new HotelManagementSystem();
    }
    
}
 
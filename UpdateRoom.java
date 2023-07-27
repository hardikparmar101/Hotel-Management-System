package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice CustomerC ;
    JTextField  txtRoom , txtlblAvailability, txtCleaning, txtAmount,txtAmountPndg; 
    JButton check, update , back   ;
    UpdateRoom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbl1 = new JLabel("Update Room Status");
        lbl1.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbl1.setBounds(90,20,250,30);
        lbl1.setForeground(Color.BLUE);
        add(lbl1);
        
        JLabel lblID = new JLabel("Customer Id");
        lblID.setBounds(30,80,100,25);
        add(lblID);
        
        CustomerC = new Choice();
        CustomerC.setBounds(200,80,150,25);
        add(CustomerC);
        
        try{
            
            Conn con = new Conn();
            ResultSet  Rs = con.s.executeQuery("Select * from customer");
            while(Rs.next()){
                CustomerC.add(Rs.getNString("number"));   // jo values hame customer table mai se chahiye ex: number form customer table
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblRoom  = new JLabel("Room number");
        lblRoom.setBounds(30,130,100,25);
        add(lblRoom);
      
        txtRoom  = new JTextField();
        txtRoom.setBounds(200,130,150,25);
        add(txtRoom);
        
        
        JLabel lblAvailability  = new JLabel("Availability");
        lblAvailability.setBounds(30,180,100,25);
        add(lblAvailability);
        
        txtlblAvailability  = new JTextField();
        txtlblAvailability.setBounds(200,180,150,25);
        add(txtlblAvailability);
        
         JLabel lblCleaning  = new JLabel("Cleaning Status");
        lblCleaning.setBounds(30,230,100,25);
        add(lblCleaning);
        
        txtCleaning  = new JTextField();
        txtCleaning.setBounds(200,230,150,25);
        add(txtCleaning);
        
       
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2      = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel img    =  new JLabel(i1);
        img.setBounds(400,50,500,300);
        add(img);
        
        
        
        
        
        
        setBounds(300,200,980,450);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == check){
            String id  = CustomerC.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conn con = new Conn();
                ResultSet Rs = con.s.executeQuery(query);
                while(Rs.next()){
                    txtRoom.setText(Rs.getNString("number"));
                    txtlblAvailability.setText(Rs.getNString("Availability"));
                    txtCleaning.setText(Rs.getNString("checkIN"));
                    txtAmount.setText(Rs.getNString("deposit"));
                    
                }
                ResultSet Rs2  = con.s.executeQuery("Select * from room Where roomNo = '"+txtRoom.getText()+"'");
                while(Rs2.next()){
                        
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
        
            String number  = CustomerC.getSelectedItem();
            String room    = txtRoom.getText();
            String Name    = txtlblAvailability.getText();
            String CheckIn = txtCleaning.getText();
            String Deposit = txtAmount.getText();
            
            try{
                Conn con = new Conn();
                con.s.executeUpdate("update customer set room = '"+room+"', name = '"+Name+"' , checkIN = '"+CheckIn+"' , deposit = '"+Deposit+"'");
                 
                JOptionPane.showMessageDialog(null, "Data is Updated Successfully");
                
                setVisible(false);
                new Reception();
            }
            catch(Exception e){
            
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == back){
            
            setVisible(false);
            new Reception();
        }
        
    }
    
    public static void main(String agrs[]){
        
        new UpdateRoom();
    
    }
    
    
}

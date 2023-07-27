package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    Choice CustomerC ;
    JTextField  txtRoom , txtName, txtCheckIn, txtAmount,txtAmountPndg; 
    JButton check, update , back   ;
    UpdateCheck(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbl1 = new JLabel("Update Status");
        lbl1.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbl1.setBounds(90,20,200,30);
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
        lblRoom.setBounds(30,120,100,25);
        add(lblRoom);
      
        txtRoom  = new JTextField();
        txtRoom.setBounds(200,120,150,25);
        add(txtRoom);
        
        
        JLabel lblName  = new JLabel("Name");
        lblName.setBounds(30,160,100,25);
        add(lblName);
        
        txtName  = new JTextField();
        txtName.setBounds(200,160,150,25);
        add(txtName);
        
         JLabel lblCheckIn  = new JLabel("CheckIn Time");
        lblCheckIn.setBounds(30,200,100,25);
        add(lblCheckIn);
        
        txtCheckIn  = new JTextField();
        txtCheckIn.setBounds(200,200,150,25);
        add(txtCheckIn);
        
         JLabel lblAmount  = new JLabel("Amount Paid");
        lblAmount.setBounds(30,240,100,25);
        add(lblAmount);
        
        txtAmount  = new JTextField();
        txtAmount.setBounds(200,240,150,25);
        add(txtAmount);
        
         JLabel lblAmountPndg  = new JLabel("Amount Pending");
        lblAmountPndg.setBounds(30,280,100,25);
        add(lblAmountPndg);
        
        txtAmountPndg  = new JTextField();
        txtAmountPndg.setBounds(200,280,150,25);
        add(txtAmountPndg);
        
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel img    =  new JLabel(i1);
        img.setBounds(400,50,500,300);
        add(img);
        
        
        
        
        
        
        setBounds(300,200,980,500);
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
                    txtName.setText(Rs.getNString("name"));
                    txtCheckIn.setText(Rs.getNString("checkIN"));
                    txtAmount.setText(Rs.getNString("deposit"));
                    
                }
                ResultSet Rs2  = con.s.executeQuery("Select * from room Where roomNo = '"+txtRoom.getText()+"'");
                while(Rs2.next()){
                        String price  = Rs2.getNString("price");
                        int AmountPaid = Integer.parseInt(price)  - Integer.parseInt(txtAmount.getText());
                        txtAmountPndg.setText(""+AmountPaid);
                
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
        
            String number  = CustomerC.getSelectedItem();
            String room    = txtRoom.getText();
            String Name    = txtName.getText();
            String CheckIn = txtCheckIn.getText();
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
        
        new UpdateCheck();
    
    }
    
    
}

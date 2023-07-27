package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;
 
public class Login  extends JFrame implements ActionListener{  

    //Glouble 
//    JTextField txtName , txtPwd ; 
    JTextField txtName ;
    JPasswordField txtPwd ; 
    JButton  login , Cancel ; 
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel user   = new JLabel("USer Name");
        user.setBounds(40,20,100,30);
        add(user);
        
        txtName = new JTextField();
        txtName.setBounds(150,20,150,30);   
        add(txtName);
        
        JLabel Password   = new JLabel("USer Password");
        Password.setBounds(40,70,100,30);
        add(Password);
        
        txtPwd = new JPasswordField();
        txtPwd.setBounds(150,70,150,30);   
        add(txtPwd);
        
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(180,150 ,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon icon  = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2      =  icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3  =  new ImageIcon(i2);
        JLabel img    = new JLabel(i3);
        //JLabel img  = new JLabel(i2);  // error hm direct jlabel me image(pred fun) ni dhal skte
        img.setBounds(350,10,200,200);
        add(img);
        
        setBounds(500,200,600,300);
        setVisible(true); 
        
    }
    // Action Event on button with Querys  //  or click events
     public void actionPerformed(ActionEvent ae){
            // this block for database  for get field and labels 
        if(ae.getSource()== login){     
            String Users = txtName.getText();
            String Pass = txtPwd.getText();
            
            try{                // try catch for hit database(querys);
               Conn c = new Conn();
               String query  = "Select * from Login where username = '" + Users + "and password = '" + Pass + " '";
               
              ResultSet rs  =  c.s.executeQuery(query);
           
                if(rs.next()){        //  next is funcation; 
                    setVisible(false);
                    new DashBoard(); 
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid UserName Or Password...");
                }

              
              }
            catch(Exception e){
                e.printStackTrace(); 
            }
            
        }
        else if(ae.getSource()==Cancel){
            
            setVisible(false);
        }
        
    }
    
    
    public static void main(String args[]){
        Login login1 = new Login();
        
    }

 
    
    
    
    
    
}

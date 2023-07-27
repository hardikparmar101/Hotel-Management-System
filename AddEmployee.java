 package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee  extends JFrame  implements ActionListener {

      JTextField txt1 , txt2,txt3, txt4 , txt5 ,txt6;  
      JRadioButton rb1,rb2;
      JComboBox cmb ; 
      JButton subBtn ; 
    
    public AddEmployee(){
        
        setLayout(null);
       
        // Name Label;
        JLabel lbname  = new JLabel("Name");
        lbname.setBounds(60,30,120,30);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbname);
        
        // Name Text Field ; 
        txt1     = new JTextField();
        txt1.setBounds(200 ,30,150,30 );
        add(txt1);
        
        // Age Label 
        JLabel lbAge  = new JLabel("Age");
        lbAge.setBounds(60,80,120,30);
        lbAge.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(lbAge);
        
        // age Text Field
        txt2  = new JTextField();
        txt2.setBounds(200,80,150,30);
        add(txt2);
        
        // gender Label ; 
        JLabel lbGender = new JLabel("Gender");
        lbGender.setBounds(60,120,120,30);
        lbGender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbGender);
        
        rb1  = new JRadioButton("male");
        rb1.setBounds(200,120,70,30);
        rb1.setFont(new Font("Tahoma",Font.PLAIN,14));
        rb1.setBackground(Color.WHITE); 
        add(rb1);
        rb2  = new JRadioButton("Female");
        rb2.setBounds(280,120,70,30);
        rb2.setFont(new Font("Tahoma",Font.PLAIN,14));
        rb2.setBackground(Color.WHITE);
        add(rb2);
        
        // group male and femae for fatching with database ;
        ButtonGroup bg  = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        // job :- drop down button 
        JLabel lbJobs = new JLabel("Jobs");
        lbJobs.setBounds(60,170,120,30);
        lbJobs.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbJobs);
       
        /*
        // Job Text Field
        JTextField txt4  = new JTextField();
        txt4.setBounds(200,170,150,30);
        add(txt4);
        */
        
       /* String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
         */   		
         // pick list
        String str[]   = {"----None----", "Front Desk Clerks","Porters","Housekeeping","kitchen Staff", "Room Service", "Chefs","waiter/waitress","Manager"};
        cmb  = new JComboBox(str);
        cmb.setBounds(200,175,150,30);
        cmb.setBackground(Color.WHITE);
        add(cmb);
         
         // Salary Label 
        JLabel lbSalary  = new JLabel("Salary");
        lbSalary.setBounds(60,250,120,30);
        lbSalary.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(lbSalary);
        
        // Salary Text Field
        txt3  = new JTextField();
        txt3.setBounds(200,250,150,30);
        add(txt3);
        
        
          // email Label 
        JLabel lbEmail  = new JLabel("Email");
        lbEmail.setBounds(60,300,120,30);
        lbEmail.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(lbEmail);
        
        // Email Text Field
        txt4  = new JTextField();
        txt4.setBounds(200,300,150,30);
        add(txt4);
        
        // phone Label ; 
       JLabel lbPhone = new JLabel("Phone");
       lbPhone.setBounds(60,350,120,30);
       lbPhone.setFont(new Font("Tahoma",Font.PLAIN, 17));
       add(lbPhone);
       
       txt5 = new JTextField();
       txt5.setBounds(200,350,150,30);
       add(txt5); 
       
       JLabel lbAadhar = new JLabel("Adhar Number");
       lbAadhar.setBounds(60,400,120,30);
       lbAadhar.setFont(new Font("Tahoma",Font.PLAIN, 17));
       add(lbAadhar);
       
       txt6 = new JTextField();
       txt6.setBounds(200,400,150,30);
       add(txt6); 
       
       
       
       
       
       subBtn   = new JButton("SUBMIT");
       subBtn.setBackground(Color.BLACK);
       subBtn.setForeground(Color.WHITE);
       subBtn.setBounds(200,450,150,30);
       subBtn.addActionListener(this);
       add(subBtn);
       
        
     ImageIcon imgIcn  = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));   
     Image i2      =  imgIcn.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
     ImageIcon imgIcon1 = new ImageIcon(i2);
     JLabel img   = new JLabel(imgIcon1);
     img.setBounds(380,60,450,370);  // we can crop the image with the help of setbounds
     add(img); 
     
       
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);     
    }

    public void actionPerformed(ActionEvent ac){
        // database ke liye values 
      String  name   = txt1.getText();
      String  age    = txt2.getText();
      String salary  = txt3.getText();
      String email   = txt4.getText();
      String phone   = txt5.getText();
      String adharNo = txt6.getText();
       // for Radio button; 
       String gender = null ;
       
       if(rb1.isSelected()){
           gender = "Male";
       }
       else if(rb2.isSelected()){
           gender = "Female";
       }
       
       String job =  (String)  cmb.getSelectedItem();   //   getSelectedItem return object whats y we use typecasting(String);
       
       
       if(name.equals("")){
           JOptionPane.showMessageDialog(null,"Name should not be Empty..");
           return;
       }
       
       /*if(email.equals("") &&  Include("@") && Include(".com") ){
            
       }
        */
       
       
       
      try{
           Conn con  = new Conn(); 
           String query  = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+adharNo+" ') " ;
           con.s.executeUpdate(query);  // S --> statement obj form connection class ; executeUpdate use for delete or edit etc.
           
           JOptionPane.showMessageDialog(null,"Employee Added SuccessFully"); 
      } 
      catch(Exception e){
          e.printStackTrace();
      }
       
       
       
       
        
       
       
       
       
    }
    
    
    
    public static void main(String args[]){
        
        AddEmployee addEmployee = new AddEmployee();        
        
    }

   
  
}

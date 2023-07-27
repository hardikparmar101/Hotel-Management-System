package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener {
 
    JButton newCustFrmBtn, roomsBtn, departmentBtn, allEmpBtn, managerInfoBtn, CustomerInfoBtn, searchRoomBtn,  updateBtn ;
    Reception(){
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustFrmBtn  = new JButton("New Customer Form");
        newCustFrmBtn.setBounds(10,30,200,30);
        newCustFrmBtn.setBackground(Color.BLACK);
        newCustFrmBtn.setForeground(Color.WHITE);
        newCustFrmBtn.addActionListener(this);
        add(newCustFrmBtn); 
    
        roomsBtn  = new JButton("Rooms");
        roomsBtn.setBounds(10,80,200,30);
        roomsBtn.setBackground(Color.BLACK);
        roomsBtn.setForeground(Color.WHITE);
        roomsBtn.addActionListener(this);
        add(roomsBtn); 
        
        departmentBtn  = new JButton("Departments");
        departmentBtn.setBounds(10,130,200,30);
        departmentBtn.setBackground(Color.BLACK);
        departmentBtn.setForeground(Color.WHITE);
        departmentBtn.addActionListener(this);
        add(departmentBtn);
        
        allEmpBtn  = new JButton("All Employees");
        allEmpBtn.setBounds(10,180,200,30);
        allEmpBtn.setBackground(Color.BLACK);
        allEmpBtn.setForeground(Color.WHITE);
        allEmpBtn.addActionListener(this);
        add(allEmpBtn);
        
        CustomerInfoBtn  = new JButton("Customer Info ");
        CustomerInfoBtn.setBounds(10,230,200,30);
        CustomerInfoBtn.setBackground(Color.BLACK);
        CustomerInfoBtn.setForeground(Color.WHITE);
        CustomerInfoBtn.addActionListener(this);
        add(CustomerInfoBtn);
        
        managerInfoBtn  = new JButton("Manager Info ");
        managerInfoBtn.setBounds(10,280,200,30);
        managerInfoBtn.setBackground(Color.BLACK);
        managerInfoBtn.setForeground(Color.WHITE);
        managerInfoBtn.addActionListener(this);
        add(managerInfoBtn);
        
        JButton CheckoutBtn  = new JButton("Checkout");
        CheckoutBtn.setBounds(10,330,200,30);
        CheckoutBtn.setBackground(Color.BLACK);
        CheckoutBtn.setForeground(Color.WHITE);
        add(CheckoutBtn);
        
        updateBtn  = new JButton("Update Status");
        updateBtn.setBounds(10,380,200,30);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.addActionListener(this);
        add(updateBtn);
        
        JButton roomStatusBtn  = new JButton(" Update Room Status");
        roomStatusBtn.setBounds(10,430,200,30);
        roomStatusBtn.setBackground(Color.BLACK);
        roomStatusBtn.setForeground(Color.WHITE);
        add(roomStatusBtn);
        
        JButton serviesBtn  = new JButton(" Pickup Servies");
        serviesBtn.setBounds(10,430,200,30);
        serviesBtn.setBackground(Color.BLACK);
        serviesBtn.setForeground(Color.WHITE);
        add(serviesBtn);
        
        searchRoomBtn  = new JButton(" Search Room");
        searchRoomBtn.setBounds(10,480,200,30);
        searchRoomBtn.setBackground(Color.BLACK);
        searchRoomBtn.setForeground(Color.WHITE);
        searchRoomBtn.addActionListener(this);
        add(searchRoomBtn);
        
        JButton logoutBtn  = new JButton(" Logout");
        logoutBtn.setBounds(10,530,200,30);
        logoutBtn.setBackground(Color.BLACK);
        logoutBtn.setForeground(Color.WHITE);
        add(logoutBtn);
        
        
        ImageIcon ImgIcn   =  new  ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image       = new JLabel(ImgIcn);
        image.setBounds(250,30,500,470);
        add(image); 
        
        
        
        
        
        
        setBounds(350,200,800,570);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == newCustFrmBtn   ){
            
            setVisible(false);
            new addCustomer();
        }
        else if(ae.getSource() == roomsBtn){
        
            setVisible(false);
            new Rooms();
        }
        else if(ae.getSource() == departmentBtn){
        
            setVisible(false);
            new Departments(); 
        }
        else if(ae.getSource() == allEmpBtn){
            setVisible(false);
            new AllEmployees(); 
        
        }
        else if(ae.getSource() == managerInfoBtn){
        
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == CustomerInfoBtn){
            
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == searchRoomBtn){
            setVisible(false);
            new SearchRooms();
        
        }
        else if(ae.getSource() ==  updateBtn ){
        
                setVisible(false);
                new UpdateCheck();
        }
       
    }
    
    
    public static void main(String arg[]){
        
        new Reception();
    }
    
    
    
}

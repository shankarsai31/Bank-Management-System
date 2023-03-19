
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balenquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(230,370,700,45);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);
        
         deposit=new JButton("Rs 100");
        deposit.setBounds(215,450,90,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(305,450,130,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(215,480,90,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(305,480,130,20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(215,515,90,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenquiry=new JButton("Rs 10000");
        balenquiry.setBounds(305,515,130,20);
        balenquiry.addActionListener(this);
        image.add(balenquiry);
        
        exit=new JButton("BACK");
        exit.setBounds(305,545,130,20);
        exit.addActionListener(this);
        image.add(exit);
        
       
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }

   
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                
                if(ae.getSource()!=exit &&balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }
                
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
       new FastCash("");
    }
}

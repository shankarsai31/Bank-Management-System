
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balenquiry,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(230,370,700,45);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);
        
         deposit=new JButton("Deposit");
        deposit.setBounds(215,450,90,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(305,450,130,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(215,480,90,20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(305,480,130,20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(215,515,90,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenquiry=new JButton("Balance Enquiry");
        balenquiry.setBounds(305,515,130,20);
        balenquiry.addActionListener(this);
        image.add(balenquiry);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
       new Transactions("");
    }
}

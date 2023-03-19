
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Deposit extends JFrame implements ActionListener{
    String pinnumber;
    JTextField amount;
    JButton deposit,back;
    
    
    Deposit(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to deposit");
         text.setBounds(230,370,700,45);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,10));
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(250,410,170,22);
        image.add(amount);
        
        
        
        
        deposit=new JButton("Deposit");
        deposit.setBounds(305,515,130,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        back=new JButton("Back");
        back.setBounds(305,545,130,20);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                
            }else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
            }    
        }else if(ae.getSource()==back){
            new Transactions(pinnumber).setVisible(true);
        }
    }
 
    public static void main(String args[]) {
       new Deposit("");
    }
}

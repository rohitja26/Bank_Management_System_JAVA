package bank.management.system.Enquiry;

import bank.management.system.DBConnection.Con;
import bank.management.system.main_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel l2;
    JButton b1;
    String pin;
    public BalanceEnquiry(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,1100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1100);
        add(image);

        JLabel l1 = new JLabel("Your Current Balance is:-  ");
        l1.setFont(new Font("System", Font.BOLD,14));
        l1.setForeground(Color.white);
        l1.setBounds(430,230,400,35);
        image.add(l1);

        l2 = new JLabel("");
        l2.setFont(new Font("System", Font.BOLD,18));
        l2.setForeground(Color.white);
        l2.setBounds(460,280,400,35);
        image.add(l2);


        b1 = new JButton("BACK");
        b1.setBounds(700,546,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);

        int balance = 0;

        try {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposite")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        l2.setText(""+balance);
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

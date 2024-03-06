package bank.management.system;

import bank.management.system.Enquiry.BalanceEnquiry;
import bank.management.system.Enquiry.Mini;
import bank.management.system.PinChange.Pin;
import bank.management.system.Transactions.Deposite;
import bank.management.system.Transactions.FastCash;
import bank.management.system.Transactions.Withdrwal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    public main_Class(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,1100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1100);
        add(image);

        JLabel l1 = new JLabel("Please select your transaction ");
        l1.setFont(new Font("System", Font.BOLD,18));
        l1.setForeground(Color.white);
        l1.setBounds(460,280,400,35);
        image.add(l1);

        b1 = new JButton("DEPOSITE");
        b1.setBounds(407,362,150,40);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("WITHDRAWL");
        b2.setBounds(700,362,150,40);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(407,422,150,40);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT ");
        b4.setBounds(700,422,150,40);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(407,482,150,40);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(700,482,150,40);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(700,546,150,40);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        image.add(b7);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new Deposite(pin);
            setVisible(false);
        } else if (e.getSource() == b2) {
            new Withdrwal(pin);
            setVisible(false);
        } else if (e.getSource() == b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource() == b4) {
            new Mini(pin);
            setVisible(false);
        } else if (e.getSource() == b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource() == b6) {
            new BalanceEnquiry(pin);
        } else if (e.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}

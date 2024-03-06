package bank.management.system.Transactions;

import bank.management.system.DBConnection.Con;
import bank.management.system.main_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    public Deposite(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,1100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1100);
        add(image);

        JLabel l1 = new JLabel("Enter amount you want to Deposite: ");
        l1.setFont(new Font("System", Font.BOLD,18));
        l1.setForeground(Color.white);
        l1.setBounds(460,280,400,35);
        image.add(l1);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(460,330,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,18));
        image.add(textField);

        b1 = new JButton("Deposite");
        b1.setBounds(700,492,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(700,546,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        image.add(b2);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource() == b1){
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposite  ");
                } else {
                    Con c = new Con();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposite','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+ amount +" Deposite Successfull");
                    setVisible(false);
                    new main_Class(pin);
                }
            } else if(e.getSource() == b2){
                setVisible(false);
                new main_Class(pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposite("");
    }
}

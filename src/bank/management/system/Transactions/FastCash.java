package bank.management.system.Transactions;

import bank.management.system.DBConnection.Con;
import bank.management.system.main_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    public FastCash(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,1100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1100);
        add(image);

        JLabel l1 = new JLabel(" SELECT WITHDRWAL AMOUNT ");
        l1.setFont(new Font("System", Font.BOLD,18));
        l1.setForeground(Color.white);
        l1.setBounds(470,280,400,35);
        image.add(l1);

        b1 = new JButton("Rs. 100");
        b1.setBounds(407,362,150,40);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs. 200");
        b2.setBounds(700,362,150,40);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs. 500");
        b3.setBounds(407,422,150,40);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs. 1000");
        b4.setBounds(700,422,150,40);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setBounds(407,482,150,40);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setBounds(700,482,150,40);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(700,546,150,40);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        image.add(b7);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b7){
            setVisible(false);
            new main_Class(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Con c = new Con();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposite")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                String num = "17";

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffcient Balance");
                    return;
                }else {
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrwal','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs." + amount + " has been withdrwal");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

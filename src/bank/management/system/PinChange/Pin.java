package bank.management.system.PinChange;

import bank.management.system.DBConnection.Con;
import bank.management.system.main_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    public Pin(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,1100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1100);
        add(image);

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD,18));
        l1.setForeground(Color.white);
        l1.setBounds(430,250,400,35);
        image.add(l1);

        JLabel l2 = new JLabel("New PIN: ");
        l2.setFont(new Font("System", Font.BOLD,16));
        l2.setForeground(Color.white);
        l2.setBounds(430,320,400,35);
        image.add(l2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.white);
        p1.setBounds(590,325,200,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        image.add(p1);

        JLabel l3 = new JLabel("Re-Enter New PIN: ");
        l3.setFont(new Font("System", Font.BOLD,16));
        l3.setForeground(Color.white);
        l3.setBounds(430,360,400,35);
        image.add(l3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.white);
        p2.setBounds(590,365,200,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        image.add(p2);


        b1 = new JButton("CHANGE");
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


        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN doesn't match");
                return;
            }
            if(e.getSource() == b1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New Pin");
                    return;
                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                    return;
                }
                Con c = new Con();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new main_Class(pin1);
            } else if(e.getSource() == b2){
                new main_Class(pin);
                setVisible(false);
            }

        }catch (Exception E){

        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}

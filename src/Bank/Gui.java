package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gui implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JLabel label = new JLabel("UserName");
    JLabel label1=new JLabel("Account No");
    JLabel label2=new JLabel("Amount");
    JTextField userIDField = new JTextField();
    JTextField userIDField1 = new JTextField();
    JTextField userIDField2=new JTextField();
    JButton button = new JButton("Enter");

    public Gui() {
        label.setBounds(10, 30, 200, 50);
        label1.setBounds(10,80,200,50);
        label2.setBounds(10,130,200,50);
        userIDField.setBounds(85, 40, 200, 30);
        userIDField1.setBounds(85, 90, 200, 30);
        userIDField2.setBounds(85,140,200,30);
        panel.setLayout(new FlowLayout());
        button.setBounds(120, 190, 90, 30);
        button.addActionListener(this);
        frame.add(button);
        frame.add(userIDField);
        frame.add(userIDField1);
        frame.add(userIDField2);
        frame.add(label);
        frame.add(label1);
        frame.add(label2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String text;
        int text1,text2;
        if (e.getSource() == button) {
            text = userIDField.getText();
            text1= Integer.parseInt(userIDField1.getText());
            text2= Integer.parseInt(userIDField2.getText());
            try {
                new DataBase(text,text1,text2);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
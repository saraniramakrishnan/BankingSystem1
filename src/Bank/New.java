package Bank;

import javax.swing.*;
import java.awt.*;

public class New extends JFrame {

    public New() {

        setLayout(new FlowLayout());


        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel accountLabel = new JLabel("Account Number:");
        JTextField accountField = new JTextField(10);

        JLabel amountLabel=new JLabel("Amount");
        JTextField amountField=new JTextField(10);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton amountButton=new JButton("Enter");


        nameLabel.setBounds(10, 10, 80, 25);
        nameField.setBounds(100, 10, 160, 25);


        accountLabel.setBounds(10, 40, 120, 25);
        accountField.setBounds(140, 40, 120, 25);

        amountLabel.setBounds(10, 80, 120, 25);
        amountField.setBounds(140, 80, 120, 25);

        depositButton.setBounds(10, 80, 80, 25);
        withdrawButton.setBounds(100, 80, 100, 25);
        amountButton.setBounds(200,80,120,25);


        add(nameLabel);
        add(nameField);
        add(accountLabel);
        add(accountField);
        add(depositButton);
        add(withdrawButton);
        add(amountLabel);
        add(amountField);
        add(amountButton);


        setTitle("Simple Banking System");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            New gui= new New();
            gui.setVisible(true);
        });
    }
}

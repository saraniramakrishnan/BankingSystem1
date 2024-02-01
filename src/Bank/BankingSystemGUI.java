package Bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BankingSystemGUI extends JFrame {
    private Map<String, Double> accounts;

    private JTextField accountNumberField;
    private JTextField amountField;
    private JTextArea outputArea;

    public BankingSystemGUI() {
        accounts = new HashMap<>();

        setTitle("Simple Banking System");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        createComponents();
    }

    private void createComponents() {
        add(new JLabel("Account Number:"));
        accountNumberField = new JTextField(15);
        add(accountNumberField);

        add(new JLabel("Amount:"));
        amountField = new JTextField(15);
        add(amountField);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        add(createAccountButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
        add(withdrawButton);

        JButton balanceButton = new JButton("Check Balance");
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        add(balanceButton);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));
    }

    private void createAccount() {
        String accountNumber = accountNumberField.getText();
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, 0.0);
            outputArea.append("Account created: " + accountNumber + "\n");
        } else {
            outputArea.append("Account already exists: " + accountNumber + "\n");
        }
    }

    private void deposit() {
        String accountNumber = accountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            balance += amount;
            accounts.put(accountNumber, balance);
            outputArea.append("Deposited " + amount + " to account " + accountNumber + ". New balance: " + balance + "\n");
        } else {
            outputArea.append("Account not found: " + accountNumber + "\n");
        }
    }

    private void withdraw() {
        String accountNumber = accountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountNumber, balance);
                outputArea.append("Withdrawn " + amount + " from account " + accountNumber + ". New balance: " + balance + "\n");
            } else {
                outputArea.append("Insufficient funds in account " + accountNumber + "\n");
            }
        } else {
            outputArea.append("Account not found: " + accountNumber + "\n");
        }
    }

    private void checkBalance() {
        String accountNumber = accountNumberField.getText();

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            outputArea.append("Balance in account " + accountNumber + ": " + balance + "\n");
        } else {
            outputArea.append("Account not found: " + accountNumber + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new New().setVisible(true);
            }
        });
    }
}

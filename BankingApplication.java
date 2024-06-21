import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BankingApplication extends JFrame implements ActionListener {
    private JTextField accountNumberField, amountField;
    private JTextArea resultArea;
    private JButton createAccountButton, depositButton, withdrawButton, checkBalanceButton;

    private Map<String, Double> accounts;

    public BankingApplication() {
        // Initialize account storage
        accounts = new HashMap<>();

        // Set up the frame
        setTitle("Banking Application");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add form components
        add(new JLabel("Account Number:"));
        accountNumberField = new JTextField(25);
        add(accountNumberField);

        add(new JLabel("Amount:"));
        amountField = new JTextField(25);
        add(amountField);

        createAccountButton = new JButton("Create Account");
        add(createAccountButton);
        createAccountButton.addActionListener(this);

        depositButton = new JButton("Deposit");
        add(depositButton);
        depositButton.addActionListener(this);

        withdrawButton = new JButton("Withdraw");
        add(withdrawButton);
        withdrawButton.addActionListener(this);

        checkBalanceButton = new JButton("Check Balance");
        add(checkBalanceButton);
        checkBalanceButton.addActionListener(this);

        resultArea = new JTextArea(10, 30);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accountNumber = accountNumberField.getText().trim();
        String amountText = amountField.getText().trim();
        double amount = 0;

        if (!amountText.isEmpty()) {
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                resultArea.setText("Invalid amount format.");
                return;
            }
        }

        if (e.getSource() == createAccountButton) {
            createAccount(accountNumber);
        } else if (e.getSource() == depositButton) {
            deposit(accountNumber, amount);
        } else if (e.getSource() == withdrawButton) {
            withdraw(accountNumber, amount);
        } else if (e.getSource() == checkBalanceButton) {
            checkBalance(accountNumber);
        }
    }

    private void createAccount(String accountNumber) {
        if (accountNumber.isEmpty()) {
            resultArea.setText("Account number cannot be empty.");
            return;
        }
        if (accounts.containsKey(accountNumber)) {
            resultArea.setText("Account already exists.");
        } else {
            accounts.put(accountNumber, 0.0);
            resultArea.setText("Account created successfully.");
        }
    }

    private void deposit(String accountNumber, double amount) {
        if (amount <= 0) {
            resultArea.setText("Deposit amount must be positive.");
            return;
        }
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            resultArea.setText("Amount deposited successfully.\nNew Balance: " + newBalance);
        } else {
            resultArea.setText("Account does not exist.");
        }
    }

    private void withdraw(String accountNumber, double amount) {
        if (amount <= 0) {
            resultArea.setText("Withdrawal amount must be positive.");
            return;
        }
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accounts.put(accountNumber, newBalance);
                resultArea.setText("Amount withdrawn successfully.\nNew Balance: " + newBalance);
            } else {
                resultArea.setText("Insufficient funds.");
            }
        } else {
            resultArea.setText("Account does not exist.");
        }
    }

    private void checkBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            resultArea.setText("Current Balance: " + balance);
        } else {
            resultArea.setText("Account does not exist.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankingApplication());
    }
}

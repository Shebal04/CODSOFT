import java.awt.*;
import java.awt.event.*;

class atm extends Frame implements ActionListener {
    private TextField amountField;
    private Button withdrawButton, depositButton, checkBalanceButton;
    private Label messageLabel;
    private BankAccount account;

    public atm(BankAccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(300, 200);
        setLayout(new FlowLayout());

        amountField = new TextField(10);
        add(new Label("Enter amount: "));
        add(amountField);

        withdrawButton = new Button("Withdraw");
        add(withdrawButton);
        withdrawButton.addActionListener(this);

        depositButton = new Button("Deposit");
        add(depositButton);
        depositButton.addActionListener(this);

        checkBalanceButton = new Button("Check Balance");
        add(checkBalanceButton);
        checkBalanceButton.addActionListener(this);

        messageLabel = new Label("");
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    account.withdraw(amount);
                    messageLabel.setText("Withdrawal successful.");
                } else {
                    messageLabel.setText("Invalid amount.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Please enter a valid number.");
            }
        } else if (e.getSource() == depositButton) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > 0) {
                    account.deposit(amount);
                    messageLabel.setText("Deposit successful.");
                } else {
                    messageLabel.setText("Invalid amount.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Please enter a valid number.");
            }
        } else if (e.getSource() == checkBalanceButton) {
            messageLabel.setText("Current balance: $" + account.getBalance());
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100); // Initial balance of $1000
        new atm(account);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

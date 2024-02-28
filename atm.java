import java.awt.*;
import java.awt.event.*;

class atm extends Frame implements ActionListener {
    private TextField amtField;
    private Button wbutton, dbutton, checkBalButton;
    private Label messageLabel;
    private BankAccount account;

    public atm(BankAccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(300, 300);
        setLayout(new FlowLayout());

        amtField = new TextField(12);
        add(new Label("Enter amount: "));
        add(amtField);

        wbutton = new Button("Withdraw");
        add(wbutton);
        wbutton.addActionListener(this);

        dbutton = new Button("Deposit");
        add(dbutton);
        dbutton.addActionListener(this);

        checkBalButton = new Button("Check Balance");
        add(checkBalButton);
        checkBalButton.addActionListener(this);

        messageLabel = new Label("");
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == wbutton) {
            try {
                double amt = Double.parseDouble(amtField.getText());
                if  (amt > 0) {
                    account.withdraw (amt);
                    messageLabel.setText("Withdrawal successful.");
                } else {
                    messageLabel.setText("Invalid amount.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Please enter a valid number.");
            }
        } else if (e.getSource() == dbutton) {
            try {
                double amt = Double.parseDouble(amtField.getText());
                if  (amt > 0) {
                    account.deposit (amt);
                    messageLabel.setText("Deposit successful.");
                } else {
                    messageLabel.setText("Invalid amount.");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Please enter a valid number.");
            }
        } else if (e.getSource() == checkBalButton) {
            messageLabel.setText("Current bal: $" + account.getBal());
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100); // Initial bal of $100
        new atm(account);
    }
}

class BankAccount {
    private double bal;

    public BankAccount(double initialBal) {
        this.bal = initialBal;
    }

    public double getBal() {
        return bal;
    }

    public void deposit (double amt) {
        if  (amt > 0) {
            bal =bal + amt;
        }
    }

    public void withdraw (double amt) {
        if  (amt > 0 && amt <= bal) {
            bal = bal - amt;
        }
    }
}

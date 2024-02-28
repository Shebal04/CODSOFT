import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void Menu() {
        System.out.println("Welcome to the ATM Machine!! Choose any of the following options to continue.");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void Transaction() {
        while (true) {
            Menu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Visit again!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = sc.nextDouble();
        if (amount > 0) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawal of $" + amount + " successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = sc.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of $1000
        ATM atm = new ATM(account);
        atm.Transaction();
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
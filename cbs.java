package m24;

import java.util.ArrayList; // Used to store multiple Account objects
import java.util.Scanner;  // Used to get user input

// 1. Account Class
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to create a new Account object
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        System.out.println("Account " + accountNumber + " created for " + accountHolderName + " with initial balance: " + initialBalance);
    }

    // Getter methods to access account details
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance. Current balance: " + balance);
            return false;
        }
    }

    // Method to display account information
    public void displayAccountInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
        System.out.println("-----------------------");
    }
}

// 2. Bank Class
class Bank {
    // ArrayList to store all the Account objects
    private ArrayList<Account> accounts;

    // Constructor for the Bank
    public Bank() {
        accounts = new ArrayList<>();
        System.out.println("Bank system initialized.");
    }

    // Method to add a new account to the bank
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added to the bank.");
    }

    // Method to find an account by its account number
    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("Account not found: " + accountNumber);
        return null; // Return null if account is not found
    }

    // Method to list all accounts (for demonstration)
    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank yet.");
            return;
        }
        System.out.println("\n--- All Accounts in Bank ---");
        for (Account acc : accounts) {
            System.out.println("Acc No: " + acc.getAccountNumber() + ", Holder: " + acc.getAccountHolderName() + ", Balance: " + acc.getBalance());
        }
        System.out.println("----------------------------");
    }
}

// 3. Main Class with User Interface
public class cbs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Object to read user input
        Bank myBank = new Bank(); // Create a new Bank object

        // --- Create some initial accounts ---
        Account acc1 = new Account("1001", "Alice Smith", 1000.00);
        Account acc2 = new Account("1002", "Bob Johnson", 500.00);
        myBank.addAccount(acc1);
        myBank.addAccount(acc2);

        int choice;
        String accountNumber;
        double amount;
        Account currentAccount;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Show Balance");
            System.out.println("4. List All Accounts (Admin View)"); // Added for easier testing
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine()); // Read choice as a number
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0; // Set to 0 to re-loop
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    currentAccount = myBank.findAccount(accountNumber);
                    if (currentAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        try {
                            amount = Double.parseDouble(scanner.nextLine());
                            currentAccount.deposit(amount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Please enter a valid number.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    currentAccount = myBank.findAccount(accountNumber);
                    if (currentAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        try {
                            amount = Double.parseDouble(scanner.nextLine());
                            currentAccount.withdraw(amount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Please enter a valid number.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    currentAccount = myBank.findAccount(accountNumber);
                    if (currentAccount != null) {
                        currentAccount.displayAccountInfo();
                    }
                    break;

                case 4:
                    myBank.listAllAccounts();
                    break;

                case 5:
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }

        } while (choice != 5);

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
package Programs;

import java.util.Scanner;
// BankAccount class to represent user's bank account
class BankAccount {
    private double balance; // stores account balance

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // deposit method
    public void deposit(double amount) {
        if (amount > 0) { // validation
            balance += amount;
            System.out.println("Successfully deposited: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount...!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // validation
            balance -= amount;
            System.out.println("Successfully withdrawn: Rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance...!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // checkBalance method
    public void checkBalance() {
        System.out.println("Your current balance is: Rs." + balance);
    }
}

// ATM1 class to represent ATM machine
class ATM1 {
    private BankAccount account; // connect with bank account
    private Scanner scanner;     // for user input

    // Constructor connects ATM with a bank account
    public ATM1(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // User interface (menu)
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n******  ATM Menu  *****");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Display appropriate messages
            switch (choice) {
                case 1 -> withdraw();
                case 2 -> deposit();
                case 3 -> account.checkBalance();
                case 4 -> System.out.println("Thank you for using the ATM. Goodbye...!");
                default -> System.out.println("Invalid choice...! Please try again...");
            }
        } while (choice != 4); // keep looping until Exit
    }

    // Withdraw option
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount); // call BankAccount method
    }

    // Deposit option
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount); // call BankAccount method
    }
}

// Main class to run program
public class AtmInterface {
    public static void main(String[] args) {
        // Create account with initial balance Rs.500
        BankAccount account = new BankAccount(500);

        // Create ATM1 linked to account
        ATM1 atm = new ATM1(account);

        // Start ATM interface
        atm.showMenu();
    }
}

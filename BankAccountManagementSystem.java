package fourW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountManagementSystem {
    private Map<String, BankAccount> accounts;

    public BankAccountManagementSystem() {
        accounts = new HashMap<>();
    }
    
    // method for validation
    public static double getValidDoubleInput(Scanner scanner, String prompt) {
        double value = -1; // Initialize with an invalid value

        while (value < 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value < 0) {
                    System.out.println("Please enter a non-negative value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }

        return value;
    }
    
    //method validation for char
    public static int getValidIntInput(Scanner scanner, String prompt) {
        int value = -1; // Initialize with an invalid value

        while (value < 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("Please enter a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        return value;
    }



    // Method to add a new account
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    // Method to perform deposit for an account
    public void performDeposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("\t\t\tAccount not found.");
        }
    }

    // Method to perform withdrawal for an account
    public void performWithdrawal(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("\t\t\tAccount not found.");
        }
    }

    // Method to display account details for an account
    public void displayAccountDetails(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("\t\t\tAccount not found.");
        }
    }

    public static void main(String[] args) {
        BankAccountManagementSystem accountManager = new BankAccountManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean repeat =true;
       // int choice = getValidIntInput(scanner, "Enter your choice: ");

        while (repeat) {
            System.out.println("\nBank Account Management System Menu:");
            System.out.println("1. Add an Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            int choice = getValidIntInput(scanner, "Enter your choice: ");
            

            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();

                    BankAccount newAccount = new BankAccount(accountNumber, accountHolderName);
                    accountManager.addAccount(newAccount);
                    System.out.println("\t\t\tAccount added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAccountNumber = scanner.nextLine();
                    //String depositAccountNumber = scanner.nextLine();
                    double depositAmount = getValidDoubleInput(scanner, "Enter Deposit Amount: ");
                    accountManager.performDeposit(depositAccountNumber, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    //String withdrawAccountNumber = scanner.nextLine();
                    String withdrawAccountNumber = scanner.nextLine();
                    double withdrawAmount = getValidDoubleInput(scanner, "Enter Withdrawal Amount: ");
                    accountManager.performWithdrawal(withdrawAccountNumber, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String displayAccountNumber = scanner.nextLine();
                    accountManager.displayAccountDetails(displayAccountNumber);
                    break;

                case 5:
                    System.out.println("\t\t\tExiting the Bank Account Management System.");
                    scanner.close();
                    break;

                default:
                    System.out.println("\t\t\tInvalid choice. Please try again.");
            }
        }
    }
}

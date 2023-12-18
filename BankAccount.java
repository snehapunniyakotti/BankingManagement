package fourW;

//BankAccount.java
public class BankAccount {
 private String accountNumber;
 private String accountHolderName;
 private double balance;

 // Constructor
 public BankAccount(String accountNumber, String accountHolderName) {
     this.accountNumber = accountNumber;
     this.accountHolderName = accountHolderName;
     this.balance = 0.0;
 }

 // Getters and Setters 
 public String getAccountNumber() {
     return accountNumber;
 }

 public void setAccountNumber(String accountNumber) {
     this.accountNumber = accountNumber;
 }

 public String getAccountHolderName() {
     return accountHolderName;
 }

 public void setAccountHolderName(String accountHolderName) {
     this.accountHolderName = accountHolderName;
 }

 public double getBalance() {
     return balance;
 }

 // Method to deposit money into the account
 public void deposit(double amount) {
     balance += amount;
     System.out.println("\t\t\tDeposit of " + amount + " successfully made.");
 }

 // Method to withdraw money from the account
 public void withdraw(double amount) {
     if (balance >= amount) {
         balance -= amount;
         System.out.println("\t\t\tWithdrawal of " + amount + " successfully made.");
     } else {
         System.out.println("\t\t\tInsufficient balance.");
     }
 }

 // Method to display account details
 public void displayAccountDetails() {
     System.out.println("\t\t\tAccount Number: " + accountNumber);
     System.out.println("\t\t\tAccount Holder: " + accountHolderName);
     System.out.println("\t\t\tBalance: " + balance);
 }
}

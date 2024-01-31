package com.example.banking;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BankingApplication {
    private static List<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Banking Application Menu:");
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for account");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    depositAmount();
                    break;
                case 6:
                    withdrawAmount();
                    break;
                case 7:
                    searchAccount();
                    break;
                case 8:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }

        } while (choice != 8);
    }

    private static void createAccount() {
        System.out.print("Enter account name: ");
        String name = scanner.next();

        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter email: ");
        String email = scanner.next();

        System.out.print("Enter creation date: ");
        String creationDate = scanner.next();

        System.out.print("Select account type (1. Savings, 2. Current): ");
        int accountTypeChoice = scanner.nextInt();

        BankAccount newAccount;
        if (accountTypeChoice == 1) {
            newAccount = new SavingsAccount(name, accountNumber, email, creationDate, 0);
        } else if (accountTypeChoice == 2) {
            newAccount = new CurrentAccount(name, accountNumber, email, creationDate, 0);
        } else {
            System.out.println("Invalid account type choice. Account creation failed.");
            return;
        }

        accounts.add(newAccount);

        System.out.println("Account created successfully!");
    }

    private static void displayAllAccounts() {
        System.out.println("All Accounts:");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println("------------------------------");
        }
    }

    private static void updateAccount() {
        System.out.print("Enter account number to update: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter new balance: ");
                double newBalance = scanner.nextDouble();
                account.setBalance(newBalance);
                System.out.println("Account updated successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }

    private static void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        long accountNumber = scanner.nextLong();

        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
        System.out.println("Account deleted successfully!");
    }

    private static void depositAmount() {
        System.out.print("Enter account number to deposit into: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter deposit amount (minimum 500): ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount >= 500) {
                    double newBalance = account.getBalance() + depositAmount;
                    account.setBalance(newBalance);
                    System.out.println("Amount deposited successfully!");
                } else {
                    System.out.println("Deposit amount must be at least 500. Deposit failed.");
                }
                return;
            }
        }

        System.out.println("Account not found!");
    }

    private static void withdrawAmount() {
        System.out.print("Enter account number to withdraw from: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter withdrawal amount (minimum 100): ");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount >= 100 && account.getBalance() >= withdrawalAmount) {
                    double newBalance = account.getBalance() - withdrawalAmount;
                    account.setBalance(newBalance);
                    System.out.println("Amount withdrawn successfully!");
                } else if (withdrawalAmount < 100) {
                    System.out.println("Withdrawal amount must be at least 100. Withdrawal failed.");
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                return;
            }
        }

        System.out.println("Account not found!");
    }

    private static void searchAccount() {
        System.out.print("Enter account name to search: ");
        String accountName = scanner.next();

        for (BankAccount account : accounts) {
            if (account.getName().equalsIgnoreCase(accountName)) {
                System.out.println("Account found:");
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Name: " + account.getName());
                return;
            }
        }

        System.out.println("Account not found!");
    }
}

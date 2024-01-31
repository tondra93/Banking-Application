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
        long number = scanner.nextLong();

        System.out.print("Enter creation date: ");
        String creationDate = scanner.next();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        // Add validation for minimum balance if needed

        BankAccount newAccount = new BankAccount(name, number, creationDate, initialBalance);
        accounts.add(newAccount);

        System.out.println("Account created successfully!");
    }

    private static void displayAllAccounts() {
        System.out.println("All Accounts:");
        for (BankAccount account : accounts) {
            System.out.println("Name: " + account.name + ", Number: " + account.number +
                    ", Creation Date: " + account.creationDate + ", Balance: " + account.balance);
        }
    }

    private static void updateAccount() {
        System.out.print("Enter account number to update: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.number == accountNumber) {
                System.out.print("Enter new balance: ");
                double newBalance = scanner.nextDouble();
                account.balance = newBalance;
                System.out.println("Account updated successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }

    private static void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        long accountNumber = scanner.nextLong();

        accounts.removeIf(account -> account.number == accountNumber);
        System.out.println("Account deleted successfully!");
    }

    private static void depositAmount() {
        System.out.print("Enter account number to deposit into: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.number == accountNumber) {
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.balance += depositAmount;
                System.out.println("Amount deposited successfully!");
                return;
            }
        }

        System.out.println("Account not found!");
    }

    private static void withdrawAmount() {
        System.out.print("Enter account number to withdraw from: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.number == accountNumber) {
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();

                // Add validation for minimum balance if needed

                if (account.balance >= withdrawalAmount) {
                    account.balance -= withdrawalAmount;
                    System.out.println("Amount withdrawn successfully!");
                } else {
                    System.out.println("Insufficient funds!");
                }

                return;
            }
        }

        System.out.println("Account not found!");
    }

    private static void searchAccount() {
        System.out.print("Enter account number to search: ");
        long accountNumber = scanner.nextLong();

        for (BankAccount account : accounts) {
            if (account.number == accountNumber) {
                System.out.println("Account found:");
                System.out.println("Name: " + account.name + ", Number: " + account.number +
                        ", Creation Date: " + account.creationDate + ", Balance: " + account.balance);
                return;
            }
        }

        System.out.println("Account not found!");
    }
}

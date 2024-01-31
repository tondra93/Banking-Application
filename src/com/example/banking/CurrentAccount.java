package com.example.banking;

class CurrentAccount extends BankAccount {
    public CurrentAccount(String name, long accountNumber, String email, String creationDate, double balance) {
        super(name, accountNumber, email, creationDate, balance);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Current Account Information:");
        System.out.println("Name: " + getName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Creation Date: " + getCreationDate());
        System.out.println("Balance: " + getBalance());
    }
}
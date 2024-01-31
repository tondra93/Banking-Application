package com.example.banking;

abstract class BankAccount {
    private String name;
    private long accountNumber;
    private String email;
    private String creationDate;
    protected double balance;

    public BankAccount(String name, long accountNumber, String email, String creationDate, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.email = email;
        this.creationDate = creationDate;
        this.balance = balance;
    }

    // Abstract method to display account information
    public abstract void displayAccountInfo();

    // Getters and setters for encapsulation
    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


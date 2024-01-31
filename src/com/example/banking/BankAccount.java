package com.example.banking;

class BankAccount {
    String name;
    long number;
    String creationDate;
    double balance;

    public BankAccount(String name, long number, String creationDate, double balance) {
        this.name = name;
        this.number = number;
        this.creationDate = creationDate;
        this.balance = balance;
    }
}

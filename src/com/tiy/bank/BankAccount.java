package com.tiy.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by DTG2 on 08/20/16.
 */
public class BankAccount {

    private double initialBalance = 0.0;
    private double balance = 0.0;
    private String holderName;
    private String accountName;
    private LocalDateTime accountCreation = LocalDateTime.now();
    private LocalDateTime lastTransaction = LocalDateTime.now();
    DateTimeFormatter localFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Your account is overdrawn");
        }
        this.balance = balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDateTime getAccountCreation() {
        return accountCreation;
    }

    public void setAccountCreation(LocalDateTime accountCreation) {
        this.accountCreation = accountCreation;
    }

    public LocalDateTime getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(LocalDateTime lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    public double getBalance() {
        System.out.println("Your current balance is: $" + balance + ".");
     return balance;
    }

//    public void setAccountType() {
//        System.out.println("Thanks for opening your " + accountType + " account, " + holderName);
//        System.out.println("Your account was opened "+ accountCreation.toString());
//    }

    public void printInfo() {
        System.out.println("Your " + accountName + " account " + balance + " is $" + balance + ".");
        System.out.println("Your account was opened " + accountCreation.format(localFormat));
        System.out.println("Your last transaction was " + lastTransaction.format(localFormat));
    }

    public double deposit(double depositAmount) {
        lastTransaction = LocalDateTime.now();
        balance += depositAmount;
        System.out.println("Thank you " + holderName + " ." + " Your balance is $" + balance + " as of " + lastTransaction.format(localFormat) + ".");
        return balance;
    }
    public double withdraw(double withdrawAmount) {
        lastTransaction = LocalDateTime.now();
        balance -= withdrawAmount;
        System.out.println("Your balance is now $" + balance + " as of " + lastTransaction.format(localFormat) + ".");
        return balance;
    }

//    public double transfer(double transferAmount) {
//        lastTransaction = LocalDateTime.now();
//        balance
//    }


}

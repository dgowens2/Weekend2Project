package com.tiy.bank;

import java.util.HashMap;

/**
 * Created by DTG2 on 08/20/16.
 */
public class Bank {
    private String bankName = "DonaldBank";
//    private String accountType;
    private BankAccount bankAccount = new BankAccount();
    private HashMap<String, BankAccount> bankAccountHashMap;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

//    public String getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void addBankAccount(){
        System.out.println("Welcome to " + bankName + ", where everybody is your friend!");
    }

    public void printInfo() {
        System.out.println("Your account with " + bankName + " is open.");
    }

    public double getTotalInDeposits() {
        double total = 0.0;
        for (BankAccount allAccts : bankAccountHashMap.values()) {
            total = allAccts.getBalance();
        }
        return total;
    }

    public HashMap<String, BankAccount> getBankAccountHashMap() {
        return bankAccountHashMap;
    }

    public void setBankAccountHashMap(HashMap<String, BankAccount> bankAccountHashMap) {
        this.bankAccountHashMap = bankAccountHashMap;
    }
}

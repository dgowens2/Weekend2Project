package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by DTG2 on 08/20/16.
 */
public class Bank {
    String bankName = "DonaldBank";
//    private String accountType;
    private BankAccount bankAccount = new BankAccount();

//    public String getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }

    public void welcomeNote(){
    System.out.println("Welcome to " + bankName + ", where everybody is your friend!");
}

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    public void printInfo() {
        System.out.println("Your account with " + bankName + " is open.");
    }

    public double getTotalInDeposits() {
        double total = 0.0;

        HashMap<Double, BankAccount> totalInDeposits = new HashMap<Double, BankAccount>();
        BankAccount theseTotals = new BankAccount();
        totalInDeposits.put(theseTotals.getBalance(), theseTotals);

        for (BankAccount allAccts : totalInDeposits.values()) {
            System.out.println("The totals are: " + allAccts.getBalance());
        }
        return total;
    }

    public void bankAccountHashMap() {
        HashMap<String, BankAccount> myAccountHashmap = new HashMap<String, BankAccount>();
        BankAccount thisAccount = new BankAccount();
        myAccountHashmap.put(thisAccount.getAccountName(), thisAccount);

        for (BankAccount accountNames : myAccountHashmap.values()) {
            System.out.println("The accounts are: " + accountNames.getAccountName());
        }
    }

    public void writeToFile() {
        FileWriter bankWriter = null;

        try {
            File bankFile = new File("bank.txt");
            bankWriter = new FileWriter(bankFile);
            bankWriter.write("Account Holder: " + bankAccount.getHolderName() + "\n");
            bankWriter.write("Account Name: " + bankAccount.getAccountName() + "\n");
            bankWriter.write("Account Balance: " + bankAccount.getBalance() + "\n");
            bankWriter.close();
        }
        catch (Exception exception) {
            System.out.println("Exception while writing to file");
            exception.printStackTrace();
        }
        finally {
            if (bankWriter != null); {
                try {
                    bankWriter.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void readFromFile() {
        try {
            File bankFile = new File("C:\\Users\\Donald Gowens Jr\\Dropbox\\TIY\\Sandbox\\Week2\\WeekendAssignment.bank.txt");
            Scanner fileScanner = new Scanner(bankFile);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

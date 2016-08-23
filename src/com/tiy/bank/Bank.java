package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by DTG2 on 08/20/16.
 */
public class Bank {
    String bankName = "DonaldBank";
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
//    private String accountType;
//    private BankAccount bankAccount = new BankAccount();

    public void welcomeNote(){
        System.out.println("Welcome to " + bankName + ", where everybody is your friend!");
    }

    public void addCustomer(Customer customerName) {
        customerList.add(customerName);
    }

    public void printInfo() {
        System.out.println("Your account with " + bankName + " is open.");
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

//    public BankAccount getBankAccount() {
//        return bankAccount;
//    }

//    public void setBankAccount(BankAccount bankAccount) {
//        this.bankAccount = bankAccount;
//    }


//    public double getTotalInDeposits() {
//        double total = 0.0;
//
//        HashMap<Double, BankAccount> totalInDeposits = new HashMap<Double, BankAccount>();
//        BankAccount theseTotals = new BankAccount();
//        totalInDeposits.put(theseTotals.getBalance(), theseTotals);
//
//        for (BankAccount allAccts : totalInDeposits.values()) {
//            System.out.println("The totals are: " + allAccts.getBalance());
//        }
//        return total;
//    }

//    public void bankAccountHashMap() {
//        HashMap<String, BankAccount> myAccountHashmap = new HashMap<String, BankAccount>();
//        BankAccount thisAccount = new BankAccount();
//        myAccountHashmap.put(thisAccount.getAccountName(), thisAccount);
//
//        for (BankAccount accountNames : myAccountHashmap.values()) {
//            System.out.println("The accounts are: " + accountNames.getAccountName());
//        }
//    }

    public void writeToFile() {
        FileWriter bankWriter = null;
        FileWriter accountsWriter = null;
//        Customer myCustomer = new Customer();

        try {
            File bankFile = new File("bank.txt");
            File accountsFile = new File("customer-name-accounts.txt");
            bankWriter = new FileWriter(bankFile);
            accountsWriter = new FileWriter(accountsFile);

            for (Customer myCustomer : customerList) {
                bankWriter.write("Account Holder: " + getCustomerList() + ";\n");
            }
            for (Customer myCustomer : customerList) {
                for (HashMap.Entry<String, BankAccount> currentAcct : myCustomer.customerAccounts.entrySet()) {
                    accountsWriter.write("Account Name: " + currentAcct.getKey() + "\n");
                    accountsWriter.write("Account Balance: " + currentAcct.getValue().getBalance() + "\n");
                }
            }
        bankWriter.close();
        accountsWriter.close();
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



//    public void readFromFile() {
//        try {
//            File bankFile = new File("C:\\Users\\Donald Gowens Jr\\Dropbox\\TIY\\Sandbox\\Week2\\WeekendAssignment.bank.txt");
//            Scanner fileScanner = new Scanner(bankFile);
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }

}

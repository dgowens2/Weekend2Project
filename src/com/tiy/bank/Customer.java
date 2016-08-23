package com.tiy.bank;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DTG2 on 08/22/16.
 */
public class Customer {
    private String userName;
    HashMap<String, BankAccount> customerAccounts = new HashMap<String, BankAccount>();

//    public bankAccount() {
//
//    }


//    public Customer(String userName) {
//        this.userName = userName;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public HashMap<String, BankAccount> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(HashMap<String, BankAccount> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }
}

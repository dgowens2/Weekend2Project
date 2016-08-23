package com.tiy.bank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;


/**
 * Created by DTG2 on 08/20/16.
 */
public class WeekendRunner {

    public Bank myBank = new Bank();

    public static void main(String[] args) {

        WeekendRunner myRunner = new WeekendRunner();

        myRunner.myBank.welcomeNote();

        myRunner.bankingSystem();



//        myBank.bankAccount.accountType = userInput.nextLine();
//        myBank.bankAccount.setAccountType();
    }

    public void bankingSystem () {
        Scanner userInput = new Scanner(System.in);
        WeekendRunner myRunner = new WeekendRunner();
        Customer myCustomer = new Customer();

        try {
            System.out.println("What is your name?");
            String userName = userInput.nextLine();
            myCustomer.setUserName(userName);

            System.out.println("Hi " + myCustomer.getUserName() + ".");

            System.out.println("What would you like to do today?");
            mainMenu();
        }
        catch (Exception exception){
            System.out.println("An error has occurred");
        }

    }

//    public void existingAccount() {
//
//    }

    public static void mainMenu() {
        WeekendRunner myRunner = new WeekendRunner();
        Scanner userInput = new Scanner(System.in);
        Bank myBank = new Bank();


        int mainMenuChoice;
        while (true) {
            System.out.println("1. Open a new account");
            System.out.println("2. View my Account");
//            System.out.println("3. Bank Administration");
            System.out.println("0. Exit System");

            mainMenuChoice = Integer.valueOf(userInput.nextLine());

            if (mainMenuChoice == 1) {
                newAcctMenu();
            } else if (mainMenuChoice == 2) {
                transactionMenu();
//            } else if (mainMenuChoice == 3) {
//                adminUser();
            } else if (mainMenuChoice == 0) {
                myBank.writeToFile();
                break;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public static void newAcctMenu() {
        WeekendRunner myRunner = new WeekendRunner();
        Scanner userInput = new Scanner(System.in);
        Customer myCustomer = new Customer();
        double initialDeposit;
//        int index = 1;

//        int customerSelection = Integer.valueOf(userInput.nextLine());
//        Customer myCustomer = myRunner.myBank.getCustomerList().get(customerSelection-1);

        int menuChoice;

        System.out.println("Please select one of the following choices:");

        while (true) {
            try {
                System.out.println("1. Create new checking account");
                System.out.println("2. Create new savings account");
                System.out.println("3. Create new retirement account");
                System.out.println("0. Exit this menu");

                menuChoice = Integer.valueOf(userInput.nextLine());

                if (menuChoice == 1) {
                    System.out.println("What would you like to call this account?");
                    String acctName = userInput.nextLine();
                    myCustomer.customerAccounts.put(acctName, new CheckingAccount());
                    System.out.println("How much would you like to deposit?");
                    initialDeposit = Double.valueOf(userInput.nextLine());
                    myCustomer.customerAccounts.get(acctName).setBalance(initialDeposit);
                    myRunner.myBank.writeToFile();
                } else if (menuChoice == 2) {
                    System.out.println("What would you like to call this account?");
                    String acctName = userInput.nextLine();
                    myCustomer.customerAccounts.put(acctName, new SavingsAccount());
                    System.out.println("How much would you like to deposit?");
                    initialDeposit = Double.valueOf(userInput.nextLine());
                    myCustomer.customerAccounts.get(acctName).setBalance(initialDeposit);
                    myRunner.myBank.writeToFile();
                } else if (menuChoice == 3) {
                    System.out.println("What would you like to call this account?");
                    String acctName = userInput.nextLine();
                    myCustomer.customerAccounts.put(acctName, new RetirementAccount());
                    System.out.println("How much would you like to deposit?");
                    initialDeposit = Double.valueOf(userInput.nextLine());
                    myCustomer.customerAccounts.get(acctName).setBalance(initialDeposit);
                    myRunner.myBank.writeToFile();
                } else if (menuChoice == 0) {
                    myRunner.mainMenu();
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
            catch (Exception exception) {
                System.out.println("An error has occurred");
                exception.printStackTrace();
            }
        }
    }

    public static void transactionMenu() {
        Scanner userInput = new Scanner(System.in);
        WeekendRunner myRunner = new WeekendRunner();
        Customer myCustomer = new Customer();
        Bank myBank = new Bank();

        int bankingChoice;
        while (true) {

            int index = 1;
//            System.out.println("Which user would you like to view?");
//            for (Customer currentCustomer : myBank.getCustomerList()) {
//                System.out.println(index + " - " + currentCustomer.getUserName());
//                index++;
//            }


//            int customerChoice = Integer.valueOf(userInput.nextLine());
//            Customer myOneCustomer = myBank.getCustomerList().get(customerChoice-1);

            System.out.println("Which account would you like to view?");
            for(String accountName : myCustomer.customerAccounts.keySet()) {
                System.out.println(accountName);
            }

            String userSelection = userInput.nextLine();
            System.out.println("Account: " + userSelection);
            if (userSelection == null)  {
                break;
            }

            BankAccount activeAccount = myCustomer.customerAccounts.get(userSelection);

            while (true) {
                System.out.println("\n1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Print balance information");
                System.out.println("4. Print Account Information");
                System.out.println("5. Print Bank Information");
                System.out.println("0. Exit this menu");

                bankingChoice = Integer.valueOf(userInput.nextLine());

                if (bankingChoice == 1) {
                    System.out.println("How much would you like to deposit?");
                    double amount = Double.valueOf(userInput.nextLine());
                    activeAccount.deposit(amount);
                } else if (bankingChoice == 2) {
                    System.out.println("How much would you like to withdraw?");
                    double amount = Double.valueOf(userInput.nextLine());
                    activeAccount.withdraw(amount);
                } else if (bankingChoice == 4) {
                    activeAccount.printInfo();
                } else if (bankingChoice == 5) {
                    activeAccount.printInfo();
                    myRunner.myBank.printInfo();
                } else if (bankingChoice == 3) {
                    activeAccount.getBalance();
                } else if (bankingChoice == 0) {
                    mainMenu();
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
        }
    }

//    public static void adminUser() {
//        Scanner userInput = new Scanner(System.in);
//        WeekendRunner myRunner = new WeekendRunner();
//
//        int suChoice;
//        while (true) {
//            System.out.println("\n1. Print all accounts");
//            System.out.println("2. See total bank balance");
//            System.out.println("0. Exit to the main menu");
//
//            suChoice = Integer.valueOf(userInput.nextLine());
//
//            if (suChoice == 1) {
//                System.out.println("This is a list of all user accounts");
//                myRunner.myBank.bankAccountHashMap();
//            } else if (suChoice == 2) {
//                System.out.println("The total deposit information is: ");
//                myRunner.myBank.getTotalInDeposits();
//            } else if (suChoice == 0) {
//                mainMenu();
//            } else {
//                System.out.println("Invalid selection. Please try again.");
//            }
//        }
//    }
}

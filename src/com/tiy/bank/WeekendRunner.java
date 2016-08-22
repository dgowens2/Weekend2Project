package com.tiy.bank;

import java.util.Scanner;

/**
 * Created by DTG2 on 08/20/16.
 */
public class WeekendRunner {

    public Bank myBank = new Bank();

    public static void main(String[] args) {
        WeekendRunner myRunner = new WeekendRunner();
        Scanner userInput = new Scanner(System.in);

        myRunner.myBank.addBankAccount();
        try {
            System.out.println("What is your name?");
            myRunner.myBank.getBankAccount().setHolderName(String.valueOf(userInput.nextLine()));
            //        if {userInput !=
            System.out.println("Hi " + myRunner.myBank.getBankAccount().getHolderName() + ".");

            System.out.println("What would you like to do today?");
            mainMenu();
        }
        catch (Exception exception){
            System.out.println("An error has occurred");
        }
//        myBank.bankAccount.accountType = userInput.nextLine();
//        myBank.bankAccount.setAccountType();
    }

    public static void mainMenu() {
        WeekendRunner myRunner = new WeekendRunner();
        Scanner userInput = new Scanner(System.in);

        int mainMenuChoice;
        while (true) {
            System.out.println("1. Open a new account");
            System.out.println("2. View my Account");
            System.out.println("3. Bank Administration");
            System.out.println("0. Exit System");

            mainMenuChoice = Integer.valueOf(userInput.nextLine());

            if (mainMenuChoice == 1) {
                newAcctMenu();
            } else if (mainMenuChoice == 2) {
                transactionMenu();
            } else if (mainMenuChoice == 3) {
                adminUser();
            } else if (mainMenuChoice == 0) {
                break;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public static void newAcctMenu() {
        WeekendRunner myRunner = new WeekendRunner();
        Scanner userInput = new Scanner(System.in);

        int menuChoice;

        while (true) {
//          try {
                System.out.println("1. Create new checking account");
                System.out.println("2. Create new savings account");
                System.out.println("3. Create new retirement account");
                System.out.println("0. Exit this menu");

                menuChoice = Integer.valueOf(userInput.nextLine());

                if (menuChoice == 1) {
                    System.out.println("What would you like to call this account?");
                    String acctName = userInput.nextLine();
                    CheckingAccount newCheckingAcct = new CheckingAccount();
                    newCheckingAcct.setAccountName(acctName);
                    System.out.println("How much would you like to deposit?");
                    double initialDeposit = Double.valueOf(userInput.nextLine());
                    myRunner.myBank.getBankAccount().setInitialBalance(initialDeposit);
                } else if (menuChoice == 2) {
                    System.out.println("What would you like to call this account?");
                    String acctName = userInput.nextLine();
                    SavingsAccount newSavingsAcct = new SavingsAccount();
                    newSavingsAcct.setAccountName(acctName);
                    System.out.println("How much would you like to deposit?");
                    double initialDeposit = Double.valueOf(userInput.nextLine());
                    myRunner.myBank.getBankAccount().setInitialBalance(initialDeposit);
                } else if (menuChoice == 3) {
                    System.out.println("What would you like to call this account?");
                    String acctName = userInput.nextLine();
                    RetirementAccount newRetirementAcct = new RetirementAccount();
                    newRetirementAcct.setAccountName(acctName);
                    System.out.println("How much would you like to deposit?");
                    double initialDeposit = Double.valueOf(userInput.nextLine());
                    myRunner.myBank.getBankAccount().setInitialBalance(initialDeposit);
                } else if (menuChoice == 0) {
                    mainMenu();
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
//          }
//          catch (Exception exception) {
//              System.out.println("An error has occured");
//              exception.printStackTrace();
//          }
        }
    }

    public static void transactionMenu() {
        Scanner userInput = new Scanner(System.in);
        WeekendRunner myRunner = new WeekendRunner();

        int bankingChoice;
        while (true) {
            System.out.println("Which account would you like to view?");


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
                myRunner.myBank.getBankAccount().deposit(amount);
            } else if (bankingChoice == 2) {
                System.out.println("How much would you like to withdraw?");
                double amount = Double.valueOf(userInput.nextLine());
                myRunner.myBank.getBankAccount().withdraw(amount);
            } else if (bankingChoice == 4) {
                myRunner.myBank.getBankAccount().printInfo();
            } else if (bankingChoice == 5) {
                myRunner.myBank.printInfo();
                myRunner.myBank.getBankAccount().printInfo();
            } else if (bankingChoice == 3) {
                myRunner.myBank.getBankAccount().getBalance();
            } else if (bankingChoice == 0) {
                mainMenu();
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public static void adminUser() {
        Scanner userInput = new Scanner(System.in);
        WeekendRunner myRunner = new WeekendRunner();

        int suChoice;
        while (true) {
            System.out.println("\n1. Print all accounts");
            System.out.println("2. See total bank balance");
            System.out.println("0. Exit to the main menu");

            suChoice = Integer.valueOf(userInput.nextLine());

            if (suChoice == 1) {
                System.out.println("This is a list of all user accounts");
                myRunner.myBank.getBankAccountHashMap();
            } else if (suChoice == 2) {
                System.out.println("The total deposit information is: ");
                myRunner.myBank.getTotalInDeposits();
            } else if (suChoice == 0) {
                mainMenu();
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}

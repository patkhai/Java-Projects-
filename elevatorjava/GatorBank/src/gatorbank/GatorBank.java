/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatorbank;

import java.util.Scanner;

/**
 *
 * @author patkhai
 */
public class GatorBank {

    /**
     * @param args the command line arguments
     */
    double currentBal;
    int Checkings = 500;
    int Savings = 1000;
    String Account;
    Scanner input = new Scanner(System.in);

    public void Trans() {
        int selection;
        do {
            
            // declaration of variables
            System.out.print("\nWhich account would you like to operate on ? \nSavings (S) or Checkings (C): "); //prompt the user for the type of account
            Account = input.next();
            System.out.println("Select from the following menu options below:\n");

            System.out.println("| 1  Check Balance   |");
            System.out.println("| 2  Withdrawal      |");
            System.out.println("| 3  Deposit         |");
            System.out.println("| 4  Exit            |");
            System.out.print("Please select your option now: ");
            selection = input.nextInt(); //asking user to choose
            switch (selection) { //if user chooses one of these options
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawFunds();
                    break;
                case 3:
                    depositFunds();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM! \n Goodbye! \n");
            }
        } while (selection != 4);
    }
    
    public void checkBalance() {

        if (Account.startsWith("S")) { // selection of the account type that starts with S
            System.out.print("The balance is: $" + Savings);
        } else if (Account.startsWith("C")) { // selection of the account type that starts with C
            System.out.print("The balance is: $" + Checkings);
        }
    }

    public void withdrawFunds() {
        if (Account.startsWith("S")) { // selection of the account type that starts with S
            System.out.print("Enter the withdrawl amount: $");
            int withdrawl = input.nextInt(); // ask for how much user want to withdrawl

            while (withdrawl > 900) { // maximum amount of money user is allow to withdrawl
                System.out.print("Withdrawl not allowed.");
            }
            Savings -= withdrawl; // subtract the withdrawl amount from the desire account
            System.out.print("Your New Balance: $" + Savings);

        } else if (Account.startsWith("C")) { // selection of the account type that starts with C
            System.out.print("Enter the withdrawl amount: $");
            int withdrawl = input.nextInt(); // ask for how much user want to withdrawl

            while (withdrawl > 900) { // maximum amount of money user is allow to withdrawl
                System.out.print("Withdrawl not allowed.");
            }
            Checkings -= withdrawl; // subtract the withdrawl amount from the desire account
            System.out.print("Your New Balance: $" + Checkings);
        }

    }

    public void depositFunds() {
             
        if (Account.startsWith("S")) { // selection of the account type that starts with S
            System.out.print("Enter deposit amount: $");
            int deposit = input.nextInt(); // ask for how much user want to deposit
            Savings += deposit; // adding the deposit amount into the desire account
            System.out.println("New Savings Account Balance : $" + Savings);
        } else if (Account.startsWith("C")) {
            int deposit = input.nextInt(); // ask for how much user want to deposit
            Checkings += deposit; // adding the deposit amount into the desire account
            System.out.println("New Checkings Account Balance : $" + Checkings);

        }

    }

    public static void main(String[] args) {
        new GatorBank().Trans(); //calling back the method
    }
}

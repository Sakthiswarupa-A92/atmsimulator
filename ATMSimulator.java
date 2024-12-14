import java.util.Scanner;
import java.io.*;
import java.net.*;
class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        if (initialBalance >= 0) 
        {
            this.balance = initialBalance;
        } 
        else 
        {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative.");
        }
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Successfully deposited" + amount);
        } 
        else 
        {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Successfully withdrew:" + amount);
            return true;
        } 
        else if (amount <= 0) 
        {
            System.out.println("Withdrawal amount .");
        } 
        else 
        {
            System.out.println("Insufficient funds " + balance);
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) 
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu()
    {
        int choice;
        do {
            System.out.println("\n--- ATM Display ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdraw ");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() 
    {
        System.out.println("Your current balance is" + account.getBalance());
    }

    private void deposit() 
    {
        System.out.print("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw()
    {
        System.out.print("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class ATMSimulator 
{
    public static void main(String[] args) 
    {
        BankAccount myAccount = new BankAccount(1000000.00);  
        ATM atm = new ATM(myAccount);  
        atm.showMenu();  
    }
}
import java.util.Scanner;

class ATM {
    private double balance = 1000;
    private int pin = 1234;
    private boolean loggedIn = false;

    public void verifyPin(int enteredPin) {
        if (enteredPin == pin) {
            loggedIn = true;
            System.out.println("Login Successful");
        } else {
            System.out.println("Wrong PIN");
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit Successful");
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Collect Cash");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class project4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
        atm.verifyPin(enteredPin);

        while (atm.isLoggedIn()) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                atm.checkBalance();
            } 
            else if (choice == 2) {
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                atm.deposit(amount);
            } 
            else if (choice == 3) {
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                atm.withdraw(amount);
            } 
            else if (choice == 4) {
                System.out.println("Session Ended");
                break;
            } 
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}


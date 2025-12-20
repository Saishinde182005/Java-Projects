import java.util.*;

class BankAccount {
    int accountNumber;
    String holderName;
    double balance;

    BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
}

public class project9 {
    static Map<Integer, BankAccount> accounts = new HashMap<>();

    static void createAccount(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account Already Exists");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.put(accNo, new BankAccount(accNo, name, balance));
        System.out.println("Account Created");
    }

    static BankAccount getAccount(int accNo) {
        return accounts.get(accNo);
    }

    static void deposit(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = getAccount(accNo);
        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            acc.balance += amount;
            System.out.println("Deposit Successful");
        } else {
            System.out.println("Invalid Amount");
        }
    }

    static void withdraw(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = getAccount(accNo);
        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= acc.balance) {
            acc.balance -= amount;
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    static void viewBalance(Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = getAccount(accNo);
        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.println("Account Holder: " + acc.holderName);
        System.out.println("Balance: " + acc.balance);
    }

    static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available");
            return;
        }

        System.out.println("\nAccount No\tHolder Name\tBalance");
        System.out.println("-----------------------------------------");

        for (BankAccount acc : accounts.values()) {
            System.out.println(acc.accountNumber + "\t\t" + acc.holderName + "\t\t" + acc.balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                createAccount(sc);
            } 
            else if (choice == 2) {
                deposit(sc);
            } 
            else if (choice == 3) {
                withdraw(sc);
            } 
            else if (choice == 4) {
                viewBalance(sc);
            } 
            else if (choice == 5) {
                viewAllAccounts();
            } 
            else if (choice == 6) {
                System.out.println("Program Ended");
                break;
            } 
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}

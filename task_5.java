import java.util.Scanner;

class Account {
    String acname;
    int acno;
    int ifsc;
    String loc;
    double balance;

    public Account() {}

    public Account(String acname, int acno, int ifsc, String loc, double balance) {
        this.acname = acname;
        this.acno = acno;
        this.ifsc = ifsc;
        this.loc = loc;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withmoney(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " | New Balance " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void depmoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " | New Balance " + balance);
        } else {
            System.out.println("Entered amount cannot be negative ");
        }
    }

    public String toString() {
        return "Account No: " + acno +
               "\nAccount Name: " + acname +
               "\nIFSC: " + ifsc +
               "\nLocation: " + loc +
               "\nBalance: " + balance;
    }
}

public class task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int acno = sc.nextInt();

        System.out.print("Enter IFSC code: ");
        int ifsc = sc.nextInt();

        sc.nextLine(); 
        System.out.print("Enter Location: ");
        String loc = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

   
        Account a1 = new Account(name, acno, ifsc, loc, balance);

      
        int choice;
        do {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    int wamt = sc.nextInt();
                    a1.withmoney(wamt);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double damt = sc.nextDouble();
                    a1.depmoney(damt);
                    break;
                case 3:
                    System.out.println("Current Balance: " + a1.getBalance());
                    break;
                case 4:
                    System.out.println(a1);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

import java.util.Scanner;

class Account {
    private int accountNumber;
    private int pin;
    private double balance;

    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int newPin) {
        this.pin = newPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}

public class main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample account
        Account userAccount = new Account(1001, 1234, 10000);

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (accNo == userAccount.getAccountNumber() && pin == userAccount.getPin()) {

            int choice;
            do {
                System.out.println("\n-------- ATM MENU --------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: ₹" + userAccount.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        userAccount.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        userAccount.withdraw(withdrawAmount);
                        break;

                    case 4:
                        System.out.print("Enter new PIN: ");
                        int newPin = sc.nextInt();
                        userAccount.setPin(newPin);
                        System.out.println("PIN changed successfully.");
                        break;

                    case 5:
                        System.out.println("Thank you for using ATM. Visit again!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 5);

        } else {
            System.out.println("Invalid Account Number or PIN.");
        }

        sc.close();
    }
}

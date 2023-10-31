import java.util.Scanner;

class Customer {
    private int accountNumber;
    private String name;
    private double balance;

    public Customer(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
        }
    }
}

public class Bank{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = new Customer[100]; // Assuming a maximum of 100 customers
        int customerCount = 0;

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    customers[customerCount] = new Customer(accountNumber, name, balance);
                    customerCount++;
                    System.out.println("Customer added successfully.");
                    break;
                case 2:
                    depositMoney(customers, customerCount, scanner);
                    break;
                case 3:
                    withdrawMoney(customers, customerCount, scanner);
                    break;
                case 4:
                    checkBalance(customers, customerCount, scanner);
                    break;
                case 5:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 5.");
            }
        }
    }

    private static void depositMoney(Customer[] customers, int customerCount, Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        double amount = 0;
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getAccountNumber() == accountNumber) {
                System.out.print("Enter the amount to deposit: ");
                amount = scanner.nextDouble();
                customers[i].deposit(amount);
                break;
            }
        }
        if (amount == 0) {
            System.out.println("Customer not found.");
        }
    }

    private static void withdrawMoney(Customer[] customers, int customerCount, Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        double amount = 0;
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getAccountNumber() == accountNumber) {
                System.out.print("Enter the amount to withdraw: ");
                amount = scanner.nextDouble();
                customers[i].withdraw(amount);
                break;
            }
        }
        if (amount == 0) {
            System.out.println("Customer not found.");
        }
    }

    private static void checkBalance(Customer[] customers, int customerCount, Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getAccountNumber() == accountNumber) {
                System.out.println("Account Balance: $" + customers[i].getBalance());
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void exit() {
        System.out.println("Exiting the Bank Management System.");
    }
}
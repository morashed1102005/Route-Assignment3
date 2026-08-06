package Ass_4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("===================");
            System.out.println("1- Register Customer");
            System.out.println("2- Open Account");
            System.out.println("3- Deposit");
            System.out.println("4- Withdraw");
            System.out.println("5- Transfer");
            System.out.println("6- Display Customer Accounts");
            System.out.println("7- Display All Accounts");
            System.out.println("8- Search Account");
            System.out.println("9- Search By Type");
            System.out.println("10- Close Account");
            System.out.println("0- Exit");

            choice = input.nextInt();

            switch (choice) {
                case 1:

                    input.nextLine();

                    System.out.print("Full Name: ");
                    String name = input.nextLine();

                    System.out.print("National ID: ");
                    String nationalID = input.nextLine();

                    System.out.print("Phone Number: ");
                    String phone = input.nextLine();

                    System.out.println("1. STANDARD");
                    System.out.println("2. SILVER");
                    System.out.println("3. GOLD");

                    int tierChoice = input.nextInt();

                    CustomerTier tier = CustomerTier.STANDARD;

                    switch (tierChoice) {
                        case 2:
                            tier = CustomerTier.SILVER;
                            break;
                        case 3:
                            tier = CustomerTier.GOLD;
                            break;
                    }

                    if (bank.registerCustomer(name, nationalID, phone, tier))
                        System.out.println("Customer Registered Successfully.");
                    else
                        System.out.println("Registration Failed.");

                    break;


                case 2:

                    System.out.print("Customer ID: ");
                    int customerID = input.nextInt();

                    Customer customer = bank.findCustomerByID(customerID);

                    if (customer == null) {
                        System.out.println("Customer Not Found.");
                        break;
                    }

                    System.out.print("Initial Balance: ");
                    double balance = input.nextDouble();

                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    System.out.println("3. Fixed Deposit");

                    int type = input.nextInt();

                    Account account = null;

                    switch (type) {

                        case 1:
                            System.out.print("Interest Rate: ");
                            double annualRate = input.nextDouble();
                            account = new SavingsAccount(customer, balance, "ACTIVE", annualRate);
                            break;

                        case 2:
                            System.out.print("Overdraft Limit: ");
                            double limit = input.nextDouble();
                            account = new CurrentAccount(customer, balance, "ACTIVE", limit);
                            break;

                        case 3:
                            System.out.print("Interest Rate: ");
                            double fixedRate = input.nextDouble();

                            System.out.print("Duration (Months): ");
                            int months = input.nextInt();

                            account = new FixedDepositAccount(customer, balance, "ACTIVE", fixedRate, months);
                            break;
                    }

                    if (bank.openAccount(customer, account))
                        System.out.println("Account Opened Successfully.");
                    else
                        System.out.println("Operation Failed.");

                    break;

                case 3:

                    System.out.print("Account Number: ");
                    int accNo = input.nextInt();

                    System.out.print("Amount: ");
                    double amount = input.nextDouble();

                    if (bank.depositMoney(accNo, amount))
                        System.out.println("Deposit Successful.");
                    else
                        System.out.println("Deposit Failed.");

                    break;

                case 4:

                    System.out.print("Account Number: ");
                    accNo = input.nextInt();

                    System.out.print("Amount: ");
                    amount = input.nextDouble();

                    if (bank.withdrawMoney(accNo, amount))
                        System.out.println("Withdraw Successful.");
                    else
                        System.out.println("Withdraw Failed.");

                    break;

                case 5:

                    System.out.print("From Account: ");
                    int from = input.nextInt();

                    System.out.print("To Account: ");
                    int to = input.nextInt();

                    System.out.print("Amount: ");
                    amount = input.nextDouble();

                    if (bank.transfer(from, to, amount))
                        System.out.println("Transfer Successful.");
                    else
                        System.out.println("Transfer Failed.");

                    break;

                case 6:

                    System.out.print("Customer ID: ");
                    customerID = input.nextInt();

                    bank.displayCustomerAccounts(customerID);

                    break;

                case 7:

                    bank.displayAllAccounts();

                    break;

                case 8:

                    System.out.print("Account Number: ");
                    accNo = input.nextInt();

                    bank.searchAccount(accNo);

                    break;

                case 9:

                    input.nextLine();

                    System.out.print("Account Type (Savings / Current / Fixed): ");
                    String typeName = input.nextLine();

                    bank.searchAccountsByType(typeName);

                    break;

                case 10:

                    System.out.print("Account Number: ");
                    accNo = input.nextInt();

                    if (bank.closeAccount(accNo))
                        System.out.println("Account Closed Successfully.");
                    else
                        System.out.println("Close Operation Failed.");

                    break;

                case 0:

                    System.out.println("Thank You.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 0);
        input.close();
    }
}
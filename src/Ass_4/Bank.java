package Ass_4;

public class Bank {

    private Customer[] customers = new Customer[100];
    private Account[] accounts = new Account[200];
    private int customerCount = 0;
    private int accountCount = 0;

    private Customer findCustomerByNationalID(String nationalID) {
        for (int i = 0; i<customerCount;i++){
            if (customers[i].getNationalID().equals(nationalID)){
                return customers[i];
            }


        }
        return null;
    }
    private boolean isValidPhone(String phoneNumber) {
        if (phoneNumber==null || phoneNumber.isEmpty()){
            return true;
        }
        if (phoneNumber.length() < 7 || phoneNumber.length() > 15){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++){
            if (!Character.isDigit(phoneNumber.charAt(i))){
                return false;
            }
        }
        return true;

    }

    public boolean registerCustomer(String fullName,String nationalID,String phoneNumber,CustomerTier customerTier){
        if (customerCount >= customers.length){
            return false;
        }
        if (fullName==null || fullName.isEmpty()){
            return false;
        }
        if (nationalID==null || nationalID.isEmpty()){
            return false;
        }
        if (findCustomerByNationalID(nationalID) !=null){
            return false;
        }
        if (!isValidPhone(phoneNumber)){
            return false;
        }
        if (customerTier == null ){
            return false;
        }
        Customer customer = new Customer(fullName,nationalID,phoneNumber,customerTier);
        customers[customerCount] = customer;
        customerCount++;
        return true;

    }
    public Customer findCustomerByID(int customerID){
        for (int i = 0; i < customerCount;i++){
            if (customers[i].getCustomerID() == customerID){
                return customers[i];
            }

        }
        return null;
    }
    public boolean openAccount(Customer customer, Account account){
        if (account==null || customer==null){
            return false;
        }
        if (accountCount >= accounts.length){
            return false;
        }
        accounts[accountCount] = account;
        accountCount++;

        customer.increaseOpenAccountCount();

        return true;
    }
    public Account findAccountByNumber(int accountNumber) {

        for (int i = 0; i < accountCount; i++) {

            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }

        }

        return null;
    }
    public boolean depositMoney(int accountNumber, double amount) {

        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            return false;
        }

        return account.deposit(amount);
    }
    public boolean withdrawMoney(int accountNumber, double amount) {

        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            return false;
        }

        return account.withdraw(amount);
    }
    public boolean transfer(int fromAccountNumber, int toAccountNumber, double amount) {

        if (fromAccountNumber == toAccountNumber) {
            return false;
        }

        Account from = findAccountByNumber(fromAccountNumber);
        Account to = findAccountByNumber(toAccountNumber);

        if (from == null || to == null) {
            return false;
        }

        if (!from.withdraw(amount)) {
            return false;
        }

        if (!to.deposit(amount)) {
            from.deposit(amount);
            return false;
        }

        return true;
    }
    public void searchAccount(int accountNumber) {

        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Owner: " + account.getOwner().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Status: " + account.getStatus());
        System.out.println("Transactions: " + account.getTransactionCount());
    }
    public void displayAllAccounts() {

        if (accountCount == 0) {
            System.out.println("No accounts found.");
            return;
        }

        for (int i = 0; i < accountCount; i++) {

            System.out.println("Account Number: " + accounts[i].getAccountNumber());
            System.out.println("Owner: " + accounts[i].getOwner().getFullName());
            System.out.println("Balance: " + accounts[i].getBalance());
            System.out.println("Status: " + accounts[i].getStatus());

        }
    }
    public void displayCustomerAccounts(int customerID) {

        Customer customer = findCustomerByID(customerID);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customer.displayCustomerInfo();

        double total = 0;

        for (int i = 0; i < accountCount; i++) {

            if (accounts[i].getOwner().getCustomerID() == customerID) {

                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                System.out.println("Balance: " + accounts[i].getBalance());

                total += accounts[i].getBalance();

            }

        }

        System.out.println("Total Balance = " + total);
    }
    public boolean closeAccount(int accountNumber) {

        Account account = findAccountByNumber(accountNumber);

        if (account == null) {
            return false;
        }

        if (account.getBalance() != 0) {
            return false;
        }

        account.setStatus("CLOSED");

        account.getOwner().decreaseOpenAccountCount();

        return true;
    }
    public void searchAccountsByType(String type) {

        int count = 0;
        double total = 0;

        for (int i = 0; i < accountCount; i++) {

            boolean match = false;

            if (type.equalsIgnoreCase("Savings") && accounts[i] instanceof SavingsAccount) {
                match = true;
            }

            if (type.equalsIgnoreCase("Current") && accounts[i] instanceof CurrentAccount) {
                match = true;
            }

            if (type.equalsIgnoreCase("Fixed") && accounts[i] instanceof FixedDepositAccount) {
                match = true;
            }

            if (match) {
                System.out.println("Account Number : " + accounts[i].getAccountNumber());
                System.out.println("Owner : " + accounts[i].getOwner().getFullName());
                System.out.println("Balance : " + accounts[i].getBalance());

                count++;
                total += accounts[i].getBalance();
            }
        }

        System.out.println("Number Of Accounts = " + count);
        System.out.println("Total Balance = " + total);
    }


}

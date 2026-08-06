package Ass_4;

public class Account {
    private int accountNumber;
    private static int nextAccountNumber=1;
    private Customer owner;
    private double balance;
    private String status;
    private int transactionCount;

    public Account(Customer owner, double balance, String status) {
        this.accountNumber=nextAccountNumber++;
        this.owner = owner;
        this.balance = balance;
        this.status = status;
        this.transactionCount = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public String getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }
    protected void setBalance(double balance){
        this.balance=balance;
    }
    protected void increaseTransactionCount(){
        this.transactionCount++;
    }
    protected void setStatus(String status) {
        this.status = status;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        transactionCount++;

        return true;
    }
    public boolean withdraw(double amount) {
        return false;
    }
}

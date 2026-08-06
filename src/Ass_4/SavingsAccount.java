package Ass_4;

public class SavingsAccount extends Account {
    private double annualInterestRate;
    private int monthlyWithdrawalCount;

    public SavingsAccount(Customer owner, double balance, String status, double annualInterestRate) {
        super(owner, balance, status);
        this.annualInterestRate = annualInterestRate;
        this.monthlyWithdrawalCount=0;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount > getBalance()){
            return false;
        }
        setBalance(getBalance()-amount);
        monthlyWithdrawalCount++;
        increaseTransactionCount();
        return true;
    }

}

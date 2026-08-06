package Ass_4;

public class FixedDepositAccount extends Account{

    private double interestRate;
    private int durationInMonths;
    private int elapsedMonths;

    public FixedDepositAccount(Customer owner, double balance, String status, double interestRate, int durationInMonths) {
        super(owner, balance, status);
        this.interestRate = interestRate;
        this.durationInMonths = durationInMonths;
        this.elapsedMonths = 0;
    }
    public boolean isMatured() {
        return elapsedMonths >= durationInMonths;
    }
    public void advanceOneMonth() {
        if (elapsedMonths < durationInMonths) {
            elapsedMonths++;
        }
    }
    public boolean withdraw(double amount){
        if (amount <= 0){
            return false;
        }
        if (!isMatured()){
            return false;
        }
        if (amount > getBalance()){
            return false;
        }
        setBalance(getBalance()-amount);
        increaseTransactionCount();
        return true;
    }
}

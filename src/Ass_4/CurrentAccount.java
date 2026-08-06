package Ass_4;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(Customer owner, double balance, String status, double overdraftLimit) {
        super(owner, balance, status);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw(double amount){
        if (amount <= 0){
            return false;
        }
        double newBalance = getBalance()-amount;
        if (newBalance < -overdraftLimit){
            return false;
        }
        setBalance(newBalance);
        increaseTransactionCount();
        return true;
    }
    public boolean isUsingOverdraft(){
        return getBalance() < 0;
    }
}

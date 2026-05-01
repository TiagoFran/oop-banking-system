import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String holderName;
    private double balance;
    private final List<Transaction> transactionHistory = new ArrayList<>();

    public Account(String holderName){
        this.holderName = holderName;
        this.balance = 0;
    }

    public double getBalance(){
        return balance;
    }

    public boolean deposit(double amount){
        if (amount > 0){
            credit(amount, "Deposit");
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if (amount > 0 && amount <= balance){
             debit(amount, "Withdraw");
            return true;
        }
        return false;
    }

    protected void credit(double amount, String type){
        balance += amount;
        addTransaction(type, amount);
    }

    protected void debit(double amount, String type){
        balance -= amount;
        addTransaction(type, amount);
    }

    protected void addTransaction(String type, double amount){
        transactionHistory.add(new Transaction(type, amount));
    }

    public void printTransactionHistory(){
        for (Transaction t : transactionHistory){
            System.out.println(t);
        }
    }

    public boolean transfer(Account destination, double amount){
        if (this.withdraw(amount)){
            destination.credit(amount, "Transfer recieved");
            this.addTransaction("Transfer sent", amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s : R$ %.2f", holderName, balance);
    }
}

public class CheckingAccount extends Account {

    public CheckingAccount(String holderName) {
        super(holderName);
    }

    @Override
    public boolean withdraw(double amount) {
        double fee = 2.0;
        double total = amount + fee;

        if (total <= getBalance()){
            debit(total, "Withdraw (fee)");
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Checking Account - " + super.toString();
    }
}

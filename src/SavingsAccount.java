public class SavingsAccount extends Account {

    public SavingsAccount(String holderName) {
        super(holderName);
    }

    public void applyInterest(double rate){
        double interest = getBalance() * rate;
        credit(interest, "Interest");
    }

    @Override
    public String toString(){
        return "Saving Account - " + super.toString();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String holderName = scanner.nextLine();

        SavingsAccount savings = new SavingsAccount(holderName);
        CheckingAccount checking = new CheckingAccount(holderName);

        checking.deposit(1000);
        savings.deposit(1000);

        checking.transfer(savings, 100);

        System.out.println(checking);
        System.out.println(savings);

        System.out.println("\nCheckint Account History:");
        checking.printTransactionHistory();

        System.out.println("\n---------------------------------");

        System.out.println("\nSavings Account History");
        savings.printTransactionHistory();
    }
}

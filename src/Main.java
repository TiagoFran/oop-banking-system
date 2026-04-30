import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o titular da conta: ");
        String titular = scanner.nextLine();

        ContaPoupanca poupanca = new ContaPoupanca(titular);
        ContaCorrente corrente = new ContaCorrente(titular);

        corrente.depositar(1000);

        poupanca.depositar(1000);

        corrente.transferir(poupanca, 100);

        System.out.println(corrente);
        System.out.println(poupanca);

        System.out.println("\nHistórico Conta Corrente-");
        corrente.verHistorico();

        System.out.println("---------------------------------");

        System.out.println("\nHistórico Conta Poupança-");
        poupanca.verHistorico();
    }
}

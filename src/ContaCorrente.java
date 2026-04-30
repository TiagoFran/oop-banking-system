public class ContaCorrente extends Conta {
    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public boolean sacar(double quantia) {
        double taxa = 2.0;
        double valorTotal = quantia + taxa;

        if (valorTotal <= getSaldo()){
            debitar(valorTotal, "Saque(Taxa)");
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Conta Corrente - " + super.toString();
    }
}

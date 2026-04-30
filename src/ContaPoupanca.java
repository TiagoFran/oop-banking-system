public class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular) {
        super(titular);
    }

    public void renderJuros(double taxa, String tipo){
        double rendimento = getSaldo() * taxa;
        creditar(rendimento, "Juros");
    }

    @Override
    public String toString(){
        return "Conta Poupança - " + super.toString();
    }
}

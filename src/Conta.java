import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final String titular;
    private double saldo;
    private final List<Operacao> historico = new ArrayList<>();

    public Conta(String titular){
        this.titular = titular;
        this.saldo = 0;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean depositar(double quantia){
        if (quantia > 0){
            this.saldo += quantia;
            adicionarHistorico("Depósito", quantia);
            return true;
        }
        return false;
    }

    public boolean sacar(double quantia){
        if (quantia > 0 && quantia <= saldo){
            this.saldo -= quantia;
            adicionarHistorico("Saque", quantia);
            return true;
        }
        return false;
    }

    protected void creditar(double valor, String tipo){
        this.saldo += valor;
        adicionarHistorico(tipo, valor);
    }

    protected void debitar(double valor, String tipo){
        this.saldo -= valor;
        adicionarHistorico(tipo, valor);
    }

    protected void adicionarHistorico(String tipo, double valor){
        historico.add(new Operacao(tipo, valor));
    }

    public void verHistorico(){
        for (Operacao ver : historico){
            System.out.println(ver);
        }
    }

    public boolean transferir(Conta destino, double valor){
        if (this.sacar(valor)){
            destino.depositar(valor);

            this.debitar(valor,"Transferência enviada");
            destino.creditar(valor,"Transferência recebida" );
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s : R$ %.2f", titular, saldo);
    }
}

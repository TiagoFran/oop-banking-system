import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacao {
    private final String tipo;
    private final double valor;
    private final LocalDateTime dataHora = LocalDateTime.now();

    public Operacao(String tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String novaDataHora = dataHora.format(formato);
        return String.format("[%s] : %s de R$ %.2f\n", novaDataHora, tipo, valor);
    }
}

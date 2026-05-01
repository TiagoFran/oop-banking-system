import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final String type;
    private final double amount;
    private final LocalDateTime dateTime = LocalDateTime.now();

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDate = dateTime.format(formatter);
        return String.format("[%s] : %s de R$ %.2f\n", formattedDate, type, amount);
    }
}

import java.time.LocalDateTime;

public class Amount {
    private double amount;
    private LocalDateTime timestamp;
    private String transactionType;

    public Amount(double amount, LocalDateTime timestamp, String transactionType) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        String result = transactionType + ": " + amount + " (" + timestamp + ")";
        return result;
    }
}
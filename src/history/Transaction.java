package history;

public class Transaction {

    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String type;

    public Transaction(String fromAccountNumber, String toAccountNumber, double amount, String type) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + ": " + amount + " Kč"
                + " | z: " + fromAccountNumber
                + " | na: " + toAccountNumber;
    }
}

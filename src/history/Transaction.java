package history;

import currency.Currency;

public class Transaction {

    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String type;
    private Currency currency;

    public Transaction(
            String fromAccountNumber,
            String toAccountNumber,
            double amount,
            String type,
            Currency currency
    ) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.type = type;
        this.currency = currency;
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

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return type + ": " + amount + " " + currency
                + " | z: " + fromAccountNumber
                + " | na: " + toAccountNumber;
    }
}

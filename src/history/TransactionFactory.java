package history;

import currency.Currency;

public class TransactionFactory {

    public Transaction newTransfer(
            String fromAccountNumber,
            String toAccountNumber,
            double amount,
            Currency currency
    ) {
        return new Transaction(fromAccountNumber, toAccountNumber, amount, "TRANSFER", currency);
    }

    public Transaction newDeposit(String toAccountNumber, double amount, Currency currency) {
        return new Transaction("-", toAccountNumber, amount, "DEPOSIT", currency);
    }

    public Transaction newWithdraw(String fromAccountNumber, double amount, Currency currency) {
        return new Transaction(fromAccountNumber, "-", amount, "WITHDRAW", currency);
    }
}

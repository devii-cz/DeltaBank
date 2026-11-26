package history;

import currency.Currency;
import currency.MoneyPrinter;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {

    private final List<Transaction> history = new ArrayList<>();
    private final TransactionFactory transactionFactory;
    private final MoneyPrinter moneyPrinter;

    public TransferLoggerService(TransactionFactory transactionFactory, MoneyPrinter moneyPrinter) {
        this.transactionFactory = transactionFactory;
        this.moneyPrinter = moneyPrinter;
    }

    public void logTransfer(
            String fromAccountNumber,
            String toAccountNumber,
            double amount,
            Currency currency
    ) {
        Transaction transaction = transactionFactory.newTransfer(
                fromAccountNumber,
                toAccountNumber,
                amount,
                currency
        );
        history.add(transaction);
    }

    public void logDeposit(String toAccountNumber, double amount, Currency currency) {
        Transaction transaction = transactionFactory.newDeposit(toAccountNumber, amount, currency);
        history.add(transaction);
    }

    public void logWithdraw(String fromAccountNumber, double amount, Currency currency) {
        Transaction transaction = transactionFactory.newWithdraw(fromAccountNumber, amount, currency);
        history.add(transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void printHistory() {
        IO.println("--- Historie transakcí ---");
        for (Transaction transaction : history) {
            IO.println(
                    transaction.getType() + ": "
                            + moneyPrinter.format(transaction.getAmount(), transaction.getCurrency())
                            + " | z: " + transaction.getFromAccountNumber()
                            + " | na: " + transaction.getToAccountNumber()
            );
        }
    }
}

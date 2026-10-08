package history;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {

    private List<Transaction> history = new ArrayList<>();
    private TransactionFactory transactionFactory = new TransactionFactory();

    public void logTransfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Transaction transaction = transactionFactory.newTransfer(fromAccountNumber, toAccountNumber, amount);
        history.add(transaction);
    }

    public void logDeposit(String toAccountNumber, double amount) {
        Transaction transaction = transactionFactory.newDeposit(toAccountNumber, amount);
        history.add(transaction);
    }

    public void logWithdraw(String fromAccountNumber, double amount) {
        Transaction transaction = transactionFactory.newWithdraw(fromAccountNumber, amount);
        history.add(transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void printHistory() {
        IO.println("--- Historie transakcí ---");
        for (Transaction transaction : history) {
            IO.println(transaction);
        }
    }
}

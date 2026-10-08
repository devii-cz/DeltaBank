package history;

public class TransactionFactory {

    public Transaction newTransfer(String fromAccountNumber, String toAccountNumber, double amount) {
        return new Transaction(fromAccountNumber, toAccountNumber, amount, "TRANSFER");
    }

    public Transaction newDeposit(String toAccountNumber, double amount) {
        return new Transaction("-", toAccountNumber, amount, "DEPOSIT");
    }

    public Transaction newWithdraw(String fromAccountNumber, double amount) {
        return new Transaction(fromAccountNumber, "-", amount, "WITHDRAW");
    }
}

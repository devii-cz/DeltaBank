package transfer;

import account.BankAccount;
import account.BusinessAccount;
import account.StudentAccount;
import history.TransferLoggerService;

public class TransferService {

    private static final double BUSINESS_TRANSFER_FEE_RATE = 0.003;

    private TransferLoggerService transferLoggerService;

    public TransferService(TransferLoggerService transferLoggerService) {
        this.transferLoggerService = transferLoggerService;
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Odesílací ani cílový účet nesmí být null.");
        }

        if (fromAccount == toAccount || fromAccount.getUuid().equals(toAccount.getUuid())) {
            throw new IllegalArgumentException("Nelze převádět prostředky na stejný účet.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Převáděná částka musí být větší než 0.");
        }

        double fee = 0.0;
        if (fromAccount instanceof BusinessAccount) {
            fee = amount * BUSINESS_TRANSFER_FEE_RATE;
        }

        double totalDeduction = amount + fee;
        double newBalance = fromAccount.getBalance() - totalDeduction;

        if (newBalance < getWithdrawLimit(fromAccount)) {
            throw new IllegalArgumentException("Nedostatečný zůstatek na účtu.");
        }

        fromAccount.setBalance(newBalance);
        toAccount.setBalance(toAccount.getBalance() + amount);

        transferLoggerService.logTransfer(
                fromAccount.getAccountNumber(),
                toAccount.getAccountNumber(),
                amount
        );
    }

    private int getWithdrawLimit(BankAccount account) {
        if (account instanceof StudentAccount) {
            return -5000;
        }
        return 0;
    }
}

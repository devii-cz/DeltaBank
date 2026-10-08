package transfer;

import account.BankAccount;
import account.BusinessAccount;
import account.StudentAccount;
import history.TransferLoggerService;

public class WithdrawService {
    private static final double BUSINESS_SERVICE_FEE = 0.01;

    private TransferLoggerService transferLoggerService;

    public WithdrawService(TransferLoggerService transferLoggerService) {
        this.transferLoggerService = transferLoggerService;
    }

    public void withdraw(BankAccount account, double amount) {
        double newBalance = account.getBalance() - amount;

        if (account instanceof BusinessAccount) {
            double serviceFee = amount * BUSINESS_SERVICE_FEE;

            newBalance -= serviceFee;
        }

        if (newBalance < getWithDrawLimit(account)) {
            throw new IllegalArgumentException("Cannot subtract negative amount");
        }

        account.setBalance(newBalance);

        transferLoggerService.logWithdraw(account.getAccountNumber(), amount);
    }

    private int getWithDrawLimit(BankAccount account) {
        if (account instanceof StudentAccount) {
            return -5000;
        }

        return 0;
    }

}

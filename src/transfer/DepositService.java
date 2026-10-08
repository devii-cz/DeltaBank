package transfer;

import account.BankAccount;
import account.StudentAccount;
import history.TransferLoggerService;

public class DepositService {
    private static final double STUDENT_BONUS = 0.005;

    private TransferLoggerService transferLoggerService;

    public DepositService(TransferLoggerService transferLoggerService) {
        this.transferLoggerService = transferLoggerService;
    }

    public void deposit(BankAccount bankAccount, double amount) {
        double newBalance = bankAccount.getBalance() + amount;

        if (bankAccount instanceof StudentAccount) {
            double depositBonus = amount * STUDENT_BONUS;

            newBalance += depositBonus;
        }

        bankAccount.setBalance(newBalance);

        transferLoggerService.logDeposit(bankAccount.getAccountNumber(), amount);
    }
}

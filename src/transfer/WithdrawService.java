package transfer;

import account.BankAccount;
import account.BusinessAccount;
import account.StudentAccount;

public class WithdrawService {
    private static final double BUSINESS_SERVICE_FEE = 0.01;

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
    }

    private int getWithDrawLimit(BankAccount account) {
        if (account instanceof StudentAccount) {
            return -5000;
        }

        return 0;
    }

}

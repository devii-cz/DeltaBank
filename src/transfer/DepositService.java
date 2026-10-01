package transfer;

import account.BankAccount;
import account.StudentAccount;

public class DepositService {
    private static final double STUDENT_BONUS = 0.005;

    public void deposit(BankAccount bankAccount, double amount) {
        double newBalance = bankAccount.getBalance() + amount;

        if (bankAccount instanceof StudentAccount) {
            double depositBonus = amount * STUDENT_BONUS;

            newBalance += depositBonus;
        }

        bankAccount.setBalance(newBalance);
    }
}

package account;

import person.AccountHolder;

public class SavingsAccount extends BankAccount implements InterestPoint{

    public static final float INTEREST_RATE = 0.5f;
    public SavingsAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        double newBalance = getBalance() + interest;

        super.setBalance(newBalance);
    }
}

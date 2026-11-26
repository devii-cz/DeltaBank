package account;

import currency.Currency;
import person.AccountHolder;

public class SavingsAccount extends BankAccount implements InterestPoint{

    public static final float INTEREST_RATE = 0.5f;
    public SavingsAccount(String accountNumber, AccountHolder accountHolder, Currency currency) {
        super(accountNumber, accountHolder, currency);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        double newBalance = getBalance() + interest;

        super.setBalance(newBalance);
    }
}

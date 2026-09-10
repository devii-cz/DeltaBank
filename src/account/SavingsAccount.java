package account;

import person.AccountHolder;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void add(double amount) {
        double bonus = amount*0.05;
        super.add(bonus);
        super.add(amount);
    }
}

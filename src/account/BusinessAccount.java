package account;

import person.AccountHolder;

public class BusinessAccount extends BankAccount{
    public BusinessAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void sub(double amount) {
        double fee = amount*0.1;
        super.sub(fee);
        super.sub(amount);
    }
}

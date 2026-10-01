package account;

import person.AccountHolder;

public class BusinessAccount extends BankAccount{
    public BusinessAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }
}

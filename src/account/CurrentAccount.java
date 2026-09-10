package account;

import person.AccountHolder;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(String accountNumber, AccountHolder accountHolder) {
        super(accountNumber, accountHolder);
    }
}

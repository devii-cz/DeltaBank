package account;

import currency.Currency;
import person.AccountHolder;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(String accountNumber, AccountHolder accountHolder, Currency currency) {
        super(accountNumber, accountHolder, currency);
    }
}

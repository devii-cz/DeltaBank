package account;

import currency.Currency;
import person.AccountHolder;

public class BusinessAccount extends BankAccount{
    public BusinessAccount(String accountNumber, AccountHolder accountHolder, Currency currency) {
        super(accountNumber, accountHolder, currency);
    }
}

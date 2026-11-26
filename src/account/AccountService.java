package account;

import currency.Currency;
import person.AccountHolder;

import java.util.List;

public interface AccountService {

    BankAccount createCurrentAccount(AccountHolder accountHolder, Currency currency);

    BankAccount createBusinessAccount(AccountHolder accountHolder, Currency currency);

    BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency);

    BankAccount createSavingsAccount(AccountHolder accountHolder, Currency currency);

    List<BankAccount> getBankAccounts();
}

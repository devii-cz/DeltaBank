package account;

import currency.Currency;
import person.AccountHolder;

import java.util.List;

public abstract class AccountServiceDecorator implements AccountService {

    protected final AccountService accountService;

    protected AccountServiceDecorator(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public BankAccount createCurrentAccount(AccountHolder accountHolder, Currency currency) {
        return accountService.createCurrentAccount(accountHolder, currency);
    }

    @Override
    public BankAccount createBusinessAccount(AccountHolder accountHolder, Currency currency) {
        return accountService.createBusinessAccount(accountHolder, currency);
    }

    @Override
    public BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName, Currency currency) {
        return accountService.createStudentAccount(accountHolder, schoolName, currency);
    }

    @Override
    public BankAccount createSavingsAccount(AccountHolder accountHolder, Currency currency) {
        return accountService.createSavingsAccount(accountHolder, currency);
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return accountService.getBankAccounts();
    }
}

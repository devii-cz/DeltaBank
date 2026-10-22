package account;

import person.AccountHolder;

import java.util.List;

public interface AccountService {

    BankAccount createCurrentAccount(AccountHolder accountHolder);

    BankAccount createBusinessAccount(AccountHolder accountHolder);

    BankAccount createStudentAccount(AccountHolder accountHolder, String schoolName);

    BankAccount createSavingsAccount(AccountHolder accountHolder);

    List<BankAccount> getBankAccounts();
}

package account.serialization;

import account.BankAccount;

import java.util.List;

public interface BankAccountSerializer {

    String serializeAll(List<BankAccount> bankAccounts);

    String serialize(BankAccount bankAccount);
}

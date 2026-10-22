package account.serialization;

import account.BankAccount;
import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class BankAccountGsonSerializer implements BankAccountSerializer {

    private final Gson gson = new Gson();
    private final BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        List<BankAccountSerialize> bankAccountSerialize = new LinkedList<>();

        for (BankAccount bankAccount : bankAccounts) {
            bankAccountSerialize.add(
                    bankAccountSerializeFactory.createBankAccountSerialize(bankAccount)
            );
        }

        return gson.toJson(bankAccountSerialize);
    }

    @Override
    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        return gson.toJson(bankAccountSerialize);
    }
}

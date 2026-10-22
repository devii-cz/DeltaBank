package account.serialization;

import account.BankAccount;

import java.util.List;

public class BankAccountJsonSerializer implements BankAccountSerializer {

    private final BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        int i = 0;
        for (BankAccount bankAccount : bankAccounts) {
            builder.append(this.serialize(bankAccount));
            i++;
            if (i != bankAccounts.size()) {
                builder.append(",");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    @Override
    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"accountNumber\": ");
        builder.append("\"").append(bankAccountSerialize.accountNumber).append("\"");
        builder.append("}");

        return builder.toString();
    }
}

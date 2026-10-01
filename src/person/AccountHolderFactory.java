package person;

import java.util.UUID;
import java.util.Random;

public class AccountHolderFactory {
    public AccountHolder newAccountHolder (String name, String lastName){
        String uuid = UUID.randomUUID().toString();

        return new AccountHolder(uuid, name, lastName);
    }
}

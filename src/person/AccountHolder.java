package person;

import java.util.UUID;

public class AccountHolder {
    private String uuid;
    private String name;
    private String lastName;

    public AccountHolder(String uuid, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLastName() {
        return lastName;
    }

}

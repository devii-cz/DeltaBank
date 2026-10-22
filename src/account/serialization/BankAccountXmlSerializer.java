package account.serialization;

import account.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.ArrayList;
import java.util.List;

public class BankAccountXmlSerializer implements BankAccountSerializer {

    private final XmlMapper xmlMapper = new XmlMapper();
    private final BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        BankAccountListXml listXml = new BankAccountListXml();
        listXml.bankAccountNumbers = new ArrayList<>();

        for (BankAccount bankAccount : bankAccounts) {
            listXml.bankAccountNumbers.add(
                    bankAccountSerializeFactory.createBankAccountSerialize(bankAccount).accountNumber
            );
        }

        try {
            return xmlMapper.writeValueAsString(listXml);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        BankAccountNumberXml numberXml = new BankAccountNumberXml(bankAccountSerialize.accountNumber);

        try {
            return xmlMapper.writeValueAsString(numberXml);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @JacksonXmlRootElement(localName = "bankAccountNumber")
    private static class BankAccountNumberXml {
        @JacksonXmlText
        public String value;

        public BankAccountNumberXml(String value) {
            this.value = value;
        }
    }

    @JacksonXmlRootElement(localName = "root")
    private static class BankAccountListXml {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "bankAccountNumber")
        public List<String> bankAccountNumbers;
    }
}

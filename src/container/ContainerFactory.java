package container;

import account.AccountService;
import account.BankAccountFactory;
import account.BankAccountService;
import account.serialization.BankAccountGsonSerializer;
import account.serialization.BankAccountSerializer;
import account.serialization.BankAccountXmlSerializer;
import history.TransactionFactory;
import history.TransferLoggerService;
import person.AccountHolderFactory;
import transfer.DepositService;
import transfer.TransferService;
import transfer.WithdrawService;

public class ContainerFactory {

    public Container create() {
        AccountHolderFactory accountHolderFactory = new AccountHolderFactory();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        TransactionFactory transactionFactory = new TransactionFactory();

        AccountService accountService = new BankAccountService(bankAccountFactory);
        TransferLoggerService transferLoggerService = new TransferLoggerService(transactionFactory);

        DepositService depositService = new DepositService(transferLoggerService);
        WithdrawService withdrawService = new WithdrawService(transferLoggerService);
        TransferService transferService = new TransferService(transferLoggerService);

        BankAccountSerializer jsonSerializer = new BankAccountGsonSerializer();
        BankAccountSerializer xmlSerializer = new BankAccountXmlSerializer();

        return new Container(
                accountHolderFactory,
                bankAccountFactory,
                accountService,
                transactionFactory,
                transferLoggerService,
                depositService,
                withdrawService,
                transferService,
                jsonSerializer,
                xmlSerializer
        );
    }
}

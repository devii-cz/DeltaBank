package container;

import account.AccountService;
import account.BankAccountFactory;
import account.serialization.BankAccountSerializer;
import currency.CurrencyConverter;
import currency.MoneyPrinter;
import history.TransactionFactory;
import history.TransferLoggerService;
import person.AccountHolderFactory;
import transfer.DepositService;
import transfer.TransferService;
import transfer.WithdrawService;

public class Container {

    private final AccountHolderFactory accountHolderFactory;
    private final BankAccountFactory bankAccountFactory;
    private final AccountService accountService;
    private final TransactionFactory transactionFactory;
    private final TransferLoggerService transferLoggerService;
    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final TransferService transferService;
    private final BankAccountSerializer jsonSerializer;
    private final BankAccountSerializer xmlSerializer;
    private final CurrencyConverter currencyConverter;
    private final MoneyPrinter moneyPrinter;

    public Container(
            AccountHolderFactory accountHolderFactory,
            BankAccountFactory bankAccountFactory,
            AccountService accountService,
            TransactionFactory transactionFactory,
            TransferLoggerService transferLoggerService,
            DepositService depositService,
            WithdrawService withdrawService,
            TransferService transferService,
            BankAccountSerializer jsonSerializer,
            BankAccountSerializer xmlSerializer,
            CurrencyConverter currencyConverter,
            MoneyPrinter moneyPrinter
    ) {
        this.accountHolderFactory = accountHolderFactory;
        this.bankAccountFactory = bankAccountFactory;
        this.accountService = accountService;
        this.transactionFactory = transactionFactory;
        this.transferLoggerService = transferLoggerService;
        this.depositService = depositService;
        this.withdrawService = withdrawService;
        this.transferService = transferService;
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.currencyConverter = currencyConverter;
        this.moneyPrinter = moneyPrinter;
    }

    public AccountHolderFactory getAccountHolderFactory() {
        return accountHolderFactory;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public TransferLoggerService getTransferLoggerService() {
        return transferLoggerService;
    }

    public DepositService getDepositService() {
        return depositService;
    }

    public WithdrawService getWithdrawService() {
        return withdrawService;
    }

    public TransferService getTransferService() {
        return transferService;
    }

    public BankAccountSerializer getJsonSerializer() {
        return jsonSerializer;
    }

    public BankAccountSerializer getXmlSerializer() {
        return xmlSerializer;
    }

    public CurrencyConverter getCurrencyConverter() {
        return currencyConverter;
    }

    public MoneyPrinter getMoneyPrinter() {
        return moneyPrinter;
    }
}

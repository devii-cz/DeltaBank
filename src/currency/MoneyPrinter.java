package currency;

public class MoneyPrinter {

    private final CurrencyConverter currencyConverter;
    private final Currency displayCurrency;

    public MoneyPrinter(CurrencyConverter currencyConverter, Currency displayCurrency) {
        this.currencyConverter = currencyConverter;
        this.displayCurrency = displayCurrency;
    }

    public Currency getDisplayCurrency() {
        return displayCurrency;
    }

    public String format(double amount, Currency accountCurrency) {
        if (accountCurrency == displayCurrency) {
            return amount + " " + accountCurrency;
        }

        double converted = currencyConverter.convert(amount, accountCurrency, displayCurrency);
        return amount + " " + accountCurrency + " (~" + converted + " " + displayCurrency + ")";
    }
}

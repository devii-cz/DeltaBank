package currency;

public interface CurrencyConverter {

    double convert(double amount, Currency from, Currency to);
}

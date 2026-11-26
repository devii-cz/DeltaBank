package currency;

import java.util.EnumMap;
import java.util.Map;

public class FixedRateCurrencyConverter implements CurrencyConverter {

    private final Map<Currency, Double> ratesToCzk = new EnumMap<>(Currency.class);

    public FixedRateCurrencyConverter() {
        ratesToCzk.put(Currency.CZK, 1.0);
        ratesToCzk.put(Currency.EUR, 25.0);
        ratesToCzk.put(Currency.USD, 23.0);
    }

    @Override
    public double convert(double amount, Currency from, Currency to) {
        if (from == to) {
            return amount;
        }

        double amountInCzk = amount * ratesToCzk.get(from);
        return amountInCzk / ratesToCzk.get(to);
    }
}

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.90);
        exchangeRates.put("GBP", 0.76);
        exchangeRates.put("INR", 83.95);
        exchangeRates.put("JPY", 143.06);
        exchangeRates.put("AUD", 1.49);
        // Add more currencies as needed
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // Convert to USD first, then to target
        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }
}

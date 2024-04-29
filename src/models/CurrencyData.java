package models;

import java.util.Map;

public record CurrencyData(String baseCurrency, Map<String, Double> conversionRates) {

}

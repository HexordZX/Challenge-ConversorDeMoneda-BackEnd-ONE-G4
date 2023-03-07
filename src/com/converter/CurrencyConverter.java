package com.converter;

import java.util.HashMap;

public class CurrencyConverter {
    private HashMap<String, Double> exchangeRates;

    public CurrencyConverter(HashMap<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        String key = fromCurrency + "-" + toCurrency;

        if (exchangeRates.containsKey(key)) {
            double rate = exchangeRates.get(key);
            return amount * rate;
        } else {
            throw new Exception("Invalid currency pair");
        }
    }
}

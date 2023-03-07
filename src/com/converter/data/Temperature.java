package com.converter.data;

import java.util.HashMap;

public class Temperature {
	private HashMap<String, Double> exchangeRates;
	public Temperature() {
		exchangeRates = new HashMap<>();
		exchangeRates.put("Celsius-Fahrenheit", 1.8); // 1 Celsius = 1.8 Fahrenheit
        exchangeRates.put("Celsius-Kelvin", 1.0); // 1 Celsius = 1 Kelvin
        exchangeRates.put("Fahrenheit-Celsius", 0.5556); // 1 Fahrenheit = 0.5556 Celsius
        exchangeRates.put("Fahrenheit-Kelvin", 0.5556); // 1 Fahrenheit = 0.5556 Kelvin
        exchangeRates.put("Kelvin-Celsius", -272.15); // 1 Kelvin = -272.15 Celsius
        exchangeRates.put("Kelvin-Fahrenheit", -457.87); // 1 Kelvin = -457.87 Fahrenheit
        
        //Los siguientes valores son auxiliares y se eliminarán cuando se optimicen los ComboBoxes del UI
        exchangeRates.put("Celsius-Celsius", 1.0); 
        exchangeRates.put("Fahrenheit-Fahrenheit", 1.0); 
        exchangeRates.put("Kelvin-Kelvin", 1.0); 
	}
	public HashMap<String, Double> getExchangeRates() {
		return exchangeRates;
	}
}

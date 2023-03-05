package com.converter;

import java.util.HashMap;


public class Currency{
	private HashMap<String, Double> exchangeRates;
	public Currency() {
		exchangeRates = new HashMap<>();
		exchangeRates.put("Peso Mexicano-Dolar", 0.047); // 1 peso mexicano = 0.047 dólares
		exchangeRates.put("Peso Mexicano-Libra esterlina", 0.034); // 1 peso mexicano = 0.034 libras esterlinas
		exchangeRates.put("Peso Mexicano-Yen japones", 5.34); // 1 peso mexicano = 5.34 yenes
		exchangeRates.put("Peso Mexicano-Won sur-coreano", 56.10); // 1 peso mexicano = 56.10 wones surcoreanos
		exchangeRates.put("Dolar-Peso Mexicano", 21.41); // 1 dólar = 21.41 pesos mexicanos
		exchangeRates.put("Dolar-Libra esterlina", 0.73); // 1 dólar = 0.73 libras esterlinas
		exchangeRates.put("Dolar-Yen japones", 114.70); // 1 dólar = 114.70 yenes
		exchangeRates.put("Dolar-Won sur-coreano", 1206.22); // 1 dólar = 1206.22 wones surcoreanos
		exchangeRates.put("Libra esterlina-Peso Mexicano", 29.44); // 1 libra esterlina = 29.44 pesos mexicanos
		exchangeRates.put("Libra esterlina-Dolar", 1.37);  // 1 libra esterlina = 1.37 dólares
		exchangeRates.put("Libra esterlina-Yen japones", 156.28); // 1 libra esterlina = 156.28 yenes
		exchangeRates.put("Libra esterlina-Won sur-coreano", 1643.56); // 1 libra esterlina = 1643.56 wones surcoreanos
		exchangeRates.put("Yen japones-Peso Mexicano", 0.187); // 1 yen = 0.187 pesos mexicanos
		exchangeRates.put("Yen japones-Dolar", 0.0087); // 1 yen = 0.0087 dólares
		exchangeRates.put("Yen japones-Libra esterlina", 0.0064); // 1 yen = 10.56 wones surcoreanos
		exchangeRates.put("Yen japones-Won sur-coreano", 10.56); // 1 won surcoreano = 0.00083 dólares
		exchangeRates.put("Won sur-coreano-Peso Mexicano", 0.018); // 1 won surcoreano = 0.018 pesos mexicanos
		exchangeRates.put("Won sur-coreano-Dolar", 0.00083); // 1 won surcoreano = 0.00083 dólares
		exchangeRates.put("Won sur-coreano-Libra esterlina", 0.00061); // 1 won surcoreano = 0.00061 libras esterlinas
		exchangeRates.put("Won sur-coreano-Yen japones", 0.094); // 1 won surcoreano = 0.094 yenes
		
		//Los siguientes valores son auxiliares y se eliminaran cuando optimicen los ComboBoxes del UI
		exchangeRates.put("Peso Mexicano-Peso Mexicano", 1.0); 
		exchangeRates.put("Dolar-Dolar", 1.0); 
		exchangeRates.put("Libra esterlina-Libra esterlina", 1.0);
		exchangeRates.put("Yen japones-Yen japones", 1.0); 
		exchangeRates.put("Won sur-coreano-Won sur-coreano", 1.0); 
	}

	public HashMap<String, Double> getExchangeRates() {
		return exchangeRates;
	}
	
}

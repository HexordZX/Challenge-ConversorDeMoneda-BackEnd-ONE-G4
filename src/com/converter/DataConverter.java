package com.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

public class DataConverter {
	
	private List<String> tiposConversor; 
	
	private Map<String, List<String>> valoresConversor;

	public DataConverter() {
		//Creando lista de tipos de conversores
		tiposConversor = new ArrayList<>();
		tiposConversor.add("Conversor de moneda");
		tiposConversor.add("Conversor de temperatura");
		
		//Creando mapa de valores del conversor
		valoresConversor = new HashMap<>();
		valoresConversor.put("Conversor de moneda", new ArrayList<String>() {
			{
				add("Peso Mexicano");
				add("Dolar");
				add("Libra esterlina");
				add("Yen japones");
				add("Won sur-coreano");
			}
		});
		
		valoresConversor.put("Conversor de temperatura", new ArrayList<String>() {
			{
				add("Celsius");
				add("Farenheit");
				add("Kelvin");
				
			}	
		});
		
	}
	
	public List<String> getTiposConversor() {
		return tiposConversor;
	}

	public Map<String, List<String>> getValoresConversor() {
		return valoresConversor;
	}


}

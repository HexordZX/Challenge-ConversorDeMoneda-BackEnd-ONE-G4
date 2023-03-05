package com.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

import com.ui.*;

public class DataConverter {
	
	private List<String> tiposConversor;

	private Map<String, List<String>> valoresConversor;

	public DataConverter() {
		//Creando lista de tipos de conversores
		tiposConversor = new ArrayList<>();
		tiposConversor.add("Moneda");
		tiposConversor.add("Temperatura");

		//Creando mapa de valores del conversor
		valoresConversor = new HashMap<>();
		valoresConversor.put("Moneda", new ArrayList<String>() {
			{
				add("Peso Mexicano");
				add("Dolar");
				add("Libra esterlina");
				add("Yen japones");
				add("Won sur-coreano");
			}
		});

		valoresConversor.put("Temperatura", new ArrayList<String>() {
			{
				add("Celsius");
				add("Fahrenheit");
				add("Kelvin");

			}
		});

	}


	public List<String> getTiposConversor() {
		return tiposConversor;
	}
	
	public String[] getTiposConversorToArray(){
		String[] tiposConversorToArray = getTiposConversor().toArray(new String[0]);
		return tiposConversorToArray;
	}

	public Map<String, List<String>> getValoresConversor() {
		return valoresConversor;
	}
	
	public String[] getValoresConversorDefault (String[] e) {
		List<String> valoresConversor = getValoresConversor().get(tiposConversor.get(0));
		String[] valoresConversorToArray = (String[]) valoresConversor.toArray(e);
		return valoresConversorToArray;
	}
	

}

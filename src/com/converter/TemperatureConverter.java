package com.converter;

public class TemperatureConverter {

	public double convertTemperature(String from, String to, double value) {
        // Convertir la temperatura a Kelvin
        double kelvin;
        switch (from) {
            case "Celsius":
                kelvin = value + 273.15;
                break;
            case "Fahrenheit":
                kelvin = (value + 459.67) * 5 / 9;
                break;
            default:
                kelvin = value;
                break;
        }

        // Convertir la temperatura de Kelvin a la temperatura de destino
        switch (to) {
            case "Celsius":
                return kelvin - 273.15;
            case "Fahrenheit":
                return kelvin * 9 / 5 - 459.67;
            default:
                return kelvin;
        }
    }
}

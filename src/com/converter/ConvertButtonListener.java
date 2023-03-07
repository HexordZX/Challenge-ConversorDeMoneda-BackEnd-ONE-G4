package com.converter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.converter.data.Currency;
import com.converter.data.Temperature;

public class ConvertButtonListener implements ActionListener {

	private JComboBox<String> comboBoxTypeConverter;
	private JComboBox<String> comboBoxValueFrom;
	private JComboBox<String> comboBoxValueTo;
	private JTextField inputConversor;
	private JTextField outputResultado;
	private CurrencyConverter cConverter;
	private TemperatureConverter tConverter;
	private Currency currency;
	private Temperature temperature;

	public ConvertButtonListener(JComboBox<String> comboBoxTypeConverter, JComboBox<String> comboBoxValueFrom,
			JComboBox<String> comboBoxValueTo, JTextField inputConversor, JTextField outputResultado) {
		this.comboBoxTypeConverter = comboBoxTypeConverter;
		this.comboBoxValueFrom = comboBoxValueFrom;
		this.comboBoxValueTo = comboBoxValueTo;
		this.inputConversor = inputConversor;
		this.outputResultado = outputResultado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currency = new Currency();
		temperature = new Temperature();

		if (comboBoxTypeConverter.getSelectedItem() == "Moneda") {
			cConverter = new CurrencyConverter(currency.getExchangeRates());
		} else if (comboBoxTypeConverter.getSelectedItem() == "Temperatura") {
			tConverter = new TemperatureConverter();
		}
		String from = (String) comboBoxValueFrom.getSelectedItem();
		String to = (String) comboBoxValueTo.getSelectedItem();
		double amount;

		try {
			amount = Double.parseDouble(inputConversor.getText());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Ingrese un número válido");
			return;
		}

		try {
			double result = 0;
			if (comboBoxTypeConverter.getSelectedItem() == "Moneda") {
				result = cConverter.convert(from, to, amount);
			} else if (comboBoxTypeConverter.getSelectedItem() == "Temperatura") {
				result = tConverter.convertTemperature(from, to, amount);
			}
			outputResultado.setText(String.format("%.2f", result));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}

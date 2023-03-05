package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.converter.ComboBoxUpdater;
import com.converter.Converter;
import com.converter.Currency;
import com.converter.DataConverter;
import com.converter.Temperature;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField inputConversor;
	private JTextField outputResultado;
	private JComboBox<String> comboBoxTypeConverter;
	private JComboBox<String> comboBoxValueTo;
	private JComboBox<String>  comboBoxValueFrom;
	private DataConverter data;
	private Converter converter;
	private Currency currency;
	private Temperature temperature;
	/**
	 * Create the frame.
	 */
	public UI() {
		data = new DataConverter();
		currency = new Currency();

		//Propiedades de la ventana principal

		setType(Type.UTILITY);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setTitle("Conversor Multiple");
		setFont(new Font("Roboto", Font.PLAIN, 12));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(450, 375);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));


		//Panel del convertidor multiple

		JPanel panelConverter = new JPanel();
		panelConverter.setBackground(new Color(223, 227, 238));
		contentPane.add(panelConverter);
		panelConverter.setLayout(null);

		/*
		 Este es el combobox para escoger el tipo de conversor:
		  -	Moneda
		  -	Temperatura
		 */


		comboBoxTypeConverter = new JComboBox<>(new DefaultComboBoxModel<>(data.getTiposConversorToArray()));
		comboBoxTypeConverter.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxTypeConverter.setBounds(130, 65, 196, 26);
		panelConverter.add(comboBoxTypeConverter);

		JLabel iconConverter = new JLabel("");
		iconConverter.setIcon(new ImageIcon(UI.class.getResource("/com/images/currency.png")));
		iconConverter.setBounds(48, 55, 48, 48);
		panelConverter.add(iconConverter);

//		comboBoxTypeConverter.addActionListener(new ComboBoxUpdater());
//		comboBoxTypeConverter.setSelectedIndex(0);

		comboBoxValueFrom = new JComboBox<>(new DefaultComboBoxModel<>(data.getValoresConversorDefault(new String[0])));
		comboBoxValueFrom.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxValueFrom.setEditable(true);
		comboBoxValueFrom.setBounds(15, 200, 177, 30);
		panelConverter.add(comboBoxValueFrom);

		comboBoxValueTo = new JComboBox<>(new DefaultComboBoxModel<>(data.getValoresConversorDefault(new String[0])));
		comboBoxValueTo.setEditable(true);
		comboBoxValueTo.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxValueTo.setBounds(260, 200, 177, 30);
		panelConverter.add(comboBoxValueTo);

		inputConversor = new JTextField();
		inputConversor.setFont(new Font("Roboto", Font.PLAIN, 12));
		inputConversor.setBounds(141, 149, 168, 27);
		panelConverter.add(inputConversor);
		inputConversor.setColumns(10);
		inputConversor.setText("Ingrese un valor numerico");
		inputConversor.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        if (inputConversor.getText().equals("Ingrese un valor numerico")) {
		        	inputConversor.setText("");
		        }
		    }

		    public void focusLost(FocusEvent e) {
		        if (inputConversor.getText().isEmpty()) {
		        	inputConversor.setText("Ingrese un valor numerico");
		        }
		    }
		});

		JButton buttonSwitchValue = new JButton("");
		buttonSwitchValue.setIcon(new ImageIcon(UI.class.getResource("/com/images/sync.png")));
		buttonSwitchValue.setBounds(210, 200, 32, 32);
		panelConverter.add(buttonSwitchValue);


		JLabel titleLabel = new JLabel("Tipo de Conversor");
		titleLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		titleLabel.setBounds(141, 12, 168, 30);
		panelConverter.add(titleLabel);

		JButton buttonOutputValue = new JButton("Convertir");
		buttonOutputValue.setFont(new Font("Roboto", Font.BOLD, 16));
		buttonOutputValue.setBounds(178, 242, 102, 31);
		panelConverter.add(buttonOutputValue);


		JLabel titleValue = new JLabel("Ingrese el valor a convertir");
		titleValue.setFont(new Font("Roboto", Font.PLAIN, 20));
		titleValue.setBounds(103, 104, 236, 30);
		panelConverter.add(titleValue);
		buttonOutputValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel panelOutput = new JPanel();
		FlowLayout fl_panelOutput = (FlowLayout) panelOutput.getLayout();
		fl_panelOutput.setVgap(15);
		panelOutput.setBackground(new Color(138, 157, 195));
		contentPane.add(panelOutput, BorderLayout.SOUTH);

		JLabel labelResultado = new JLabel("Resultado:  ");
		labelResultado.setFont(new Font("Roboto", Font.BOLD, 16));
		panelOutput.add(labelResultado);

		outputResultado = new JTextField();
		outputResultado.setEditable(false);
		outputResultado.setFont(new Font("Roboto", Font.PLAIN, 22));
		panelOutput.add(outputResultado);
		outputResultado.setColumns(10);

		currency = new Currency();
		temperature = new Temperature();

		comboBoxTypeConverter.addActionListener(new ComboBoxUpdater(comboBoxValueFrom, comboBoxValueTo));
		buttonOutputValue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTypeConverter.getSelectedItem() == "Moneda") {
					converter = new Converter(currency.getExchangeRates());
				} else if(comboBoxTypeConverter.getSelectedItem() == "Temperatura") {
					converter = new Converter(temperature.getExchangeRates());
				}
		            String fromCurrency = (String) comboBoxValueFrom.getSelectedItem();
		            String toCurrency = (String) comboBoxValueTo.getSelectedItem();
		            double amount;
		            double result;

		            try {
						amount = Double.parseDouble(inputConversor.getText());
					} catch (NumberFormatException e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Ingrese un número válido");
				        return;
					}

					try {
						result = converter.convert(fromCurrency, toCurrency, amount);
						outputResultado.setText(String.format("%.2f", result));
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
		    }
		});
	}

	public JComboBox<String> getComboBoxTypeConverter() {
		return this.comboBoxTypeConverter;
	}

	public void setComboBoxTypeConverter(JComboBox<String> comboBoxTypeConverter) {
		this.comboBoxTypeConverter = comboBoxTypeConverter;
	}

	public void setComboBoxValueTo(JComboBox<String> comboBoxValueTo) {
		this.comboBoxValueTo = comboBoxValueTo;
	}

	public void setComboBoxValueFrom(JComboBox<String> comboBoxValueFrom) {
		this.comboBoxValueFrom = comboBoxValueFrom;
	}

	public JComboBox<String> getComboBoxValueTo() {
		return this.comboBoxValueTo;
	}

	public JComboBox<String> getComboBoxValueFrom() {
		return this.comboBoxValueFrom;
	}


}

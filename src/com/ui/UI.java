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
import java.util.Collections;

import javax.swing.BorderFactory;
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

import com.converter.ConvertButtonListener;
import com.converter.CurrencyConverter;
import com.converter.TemperatureConverter;
import com.converter.data.Currency;
import com.converter.data.DataConverter;
import com.converter.data.Temperature;
import com.converter.listeners.ComboBoxUpdater;
import com.converter.listeners.SwapComboBoxValuesButton;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField inputConversor;
	private JTextField outputResultado;
	private JComboBox<String> comboBoxTypeConverter;
	private JComboBox<String> comboBoxValueTo;
	private JComboBox<String>  comboBoxValueFrom;
	private DataConverter data;
	/**
	 * Create the frame.
	 */
	public UI() {
		data = new DataConverter();
		new Currency();

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
		panelConverter.setBackground(new Color(189, 205, 214));
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
		comboBoxTypeConverter.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
		comboBoxTypeConverter.setBackground(new Color(238, 233, 218));
		comboBoxTypeConverter.setForeground(Color.BLACK);
		panelConverter.add(comboBoxTypeConverter);

		JLabel iconConverter = new JLabel("");
		iconConverter.setIcon(new ImageIcon(UI.class.getResource("/com/images/currency.png")));
		iconConverter.setBounds(48, 55, 48, 48);
		panelConverter.add(iconConverter);

//		comboBoxTypeConverter.addActionListener(new ComboBoxUpdater());
//		comboBoxTypeConverter.setSelectedIndex(0);

		comboBoxValueFrom = new JComboBox<>(new DefaultComboBoxModel<>(data.getValoresConversorDefault(new String[0])));
		comboBoxValueFrom.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxValueFrom.setBounds(15, 200, 177, 30);
		comboBoxValueFrom.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
		comboBoxValueFrom.setBackground(new Color(238, 233, 218));
		comboBoxValueFrom.setForeground(Color.BLACK);
		panelConverter.add(comboBoxValueFrom);

		comboBoxValueTo = new JComboBox<>(new DefaultComboBoxModel<>(data.getValoresConversorDefault(new String[0])));
		comboBoxValueTo.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxValueTo.setBounds(260, 200, 177, 30);
		comboBoxValueTo.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
		comboBoxValueTo.setBackground(new Color(238, 233, 218));
		comboBoxValueTo.setForeground(Color.BLACK);
		panelConverter.add(comboBoxValueTo);

		inputConversor = new JTextField();
		inputConversor.setFont(new Font("Roboto", Font.PLAIN, 12));
		inputConversor.setBounds(141, 149, 168, 27);
		inputConversor.setColumns(10);
		inputConversor.setText("Ingrese un valor numerico");
		inputConversor.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(147, 191, 207)));
		inputConversor.setBackground(new Color(238, 233, 218));
		panelConverter.add(inputConversor);
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
		buttonSwitchValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
		buttonSwitchValue.setBackground(new Color(147, 191, 207));
		buttonSwitchValue.setForeground(Color.BLACK);


		JLabel titleLabel = new JLabel("Tipo de Conversor");
		titleLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		titleLabel.setBounds(141, 12, 168, 30);
		titleLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, new Color(96, 150, 180)));
		panelConverter.add(titleLabel);

		JButton buttonOutputValue = new JButton("Convertir");
		buttonOutputValue.setFont(new Font("Roboto", Font.BOLD, 16));
		buttonOutputValue.setBounds(178, 242, 102, 31);
		buttonOutputValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
		buttonOutputValue.setBackground(new Color(147, 191, 207));
		buttonOutputValue.setForeground(Color.BLACK);
		panelConverter.add(buttonOutputValue);

		JLabel titleValue = new JLabel("Ingrese el valor a convertir");
		titleValue.setFont(new Font("Roboto", Font.PLAIN, 20));
		titleValue.setBounds(103, 104, 236, 30);
		panelConverter.add(titleValue);
		titleValue.setBorder(BorderFactory.createMatteBorder(0,0,1,0, new Color(96, 150, 180)));

		JPanel panelOutput = new JPanel();
		FlowLayout fl_panelOutput = (FlowLayout) panelOutput.getLayout();
		fl_panelOutput.setVgap(15);
		panelOutput.setBackground(new Color(96, 150, 180));
		contentPane.add(panelOutput, BorderLayout.SOUTH);

		JLabel labelResultado = new JLabel("Resultado:  ");
		labelResultado.setFont(new Font("Roboto", Font.BOLD, 16));
		panelOutput.add(labelResultado);

		outputResultado = new JTextField("0");
		outputResultado.setEditable(false);
		outputResultado.setBackground(new Color(238, 233, 218));
		outputResultado.setFont(new Font("Roboto", Font.PLAIN, 22));
		outputResultado.setColumns(10);
		panelOutput.add(outputResultado);

		comboBoxTypeConverter.addActionListener(new ComboBoxUpdater(comboBoxValueFrom, comboBoxValueTo, iconConverter));
		buttonSwitchValue.addActionListener(new SwapComboBoxValuesButton(comboBoxValueFrom, comboBoxValueTo));
		buttonOutputValue.addActionListener(new ConvertButtonListener(comboBoxTypeConverter, comboBoxValueFrom, comboBoxValueTo, inputConversor, outputResultado));
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

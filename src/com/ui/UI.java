package com.ui;

import com.converter.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField inputConversor;
	private JTextField outputResultado;
	private JComboBox<String> comboBoxTypeConverter;
	private JComboBox<String> comboBoxValueTo;
	private JComboBox<String>  comboBoxValueFrom;
	private DataConverter data;
	private Icon icono;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		data = new DataConverter();
		
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
		
		
		comboBoxTypeConverter = new JComboBox<>(new DefaultComboBoxModel<>(data.getTiposConversor().toArray(new String[0])));
		comboBoxTypeConverter.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxTypeConverter.setBounds(126, 65, 196, 26);
		panelConverter.add(comboBoxTypeConverter);
		
		
		JLabel iconConverter = new JLabel("");
		iconConverter.setIcon(new ImageIcon(UI.class.getResource("/com/images/currency.png")));
		iconConverter.setBounds(48, 55, 48, 48);
		panelConverter.add(iconConverter);
		
		comboBoxTypeConverter.setSelectedIndex(0);
		comboBoxTypeConverter.addActionListener(e -> ActualizarComboBoxFromTo());
		
		comboBoxValueTo = new JComboBox<>();
		comboBoxValueTo.setEditable(true);
		comboBoxValueTo.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxValueTo.setBounds(260, 200, 177, 30);
		panelConverter.add(comboBoxValueTo);

		comboBoxValueFrom = new JComboBox<>();
		comboBoxValueFrom.setFont(new Font("Roboto", Font.BOLD, 12));
		comboBoxValueFrom.setEditable(true);
		comboBoxValueFrom.setBounds(15, 200, 177, 30);
		panelConverter.add(comboBoxValueFrom);

		inputConversor = new JTextField();
		inputConversor.setFont(new Font("Roboto", Font.PLAIN, 12));
		inputConversor.setBounds(141, 149, 168, 27);
		panelConverter.add(inputConversor);
		inputConversor.setColumns(10);

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
		outputResultado.setText("Default");
		outputResultado.setEditable(false);
		outputResultado.setFont(new Font("Roboto", Font.PLAIN, 22));
		panelOutput.add(outputResultado);
		outputResultado.setColumns(10);
		
		
		
	}
	
	private void ActualizarComboBoxFromTo() {
		//Se remueven los elementos de los comboBoxValueTo y comboBoxValueFrom
		comboBoxValueFrom.removeAllItems();
		comboBoxValueTo.removeAllItems();
		
		//Se agregan los elementos correspondientes a los Comboboxes
		String conversorSeleccionado = (String) comboBoxTypeConverter.getItemAt(0);
		Map<String, List<String>> valoresMap = data.getValoresConversor();
		List<String> valoresList = valoresMap.get(conversorSeleccionado);
		
		if(valoresList != null) {			
			for(String valor : valoresList) {
				comboBoxValueFrom.addItem(valor);
				comboBoxValueTo.addItem(valor);
			}
		}
		
	}
}

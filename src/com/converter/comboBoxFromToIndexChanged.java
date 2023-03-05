package com.converter;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.ui.*;

public class comboBoxFromToIndexChanged {	
	
	private JComboBox<String> comboBoxMain;
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private DataConverter data;
	
	public comboBoxFromToIndexChanged() {
		super();
		
		
	}
	

	
	
	public comboBoxFromToIndexChanged(UI comboBoxUI) {
	
		comboBox1 = comboBoxUI.getComboBoxValueFrom();
		comboBox2 = comboBoxUI.getComboBoxValueTo();
			
		ActionListener comboListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
							
				String seleccionado = (String) comboBox.getSelectedItem();
					
				if (comboBox == comboBox1 && comboBox2.getModel().getSelectedItem().equals(seleccionado)) {
                    // Si el valor seleccionado en ComboBox1 está seleccionado en ComboBox2, mostrar un mensaje de error y deseleccionar el valor en ComboBox1
                    JOptionPane.showMessageDialog(null, "Este valor ya ha sido seleccionado en el otro ComboBox", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    comboBox1.setSelectedIndex(-1);
                } else if (comboBox == comboBox2 && comboBox1.getModel().getSelectedItem().equals(seleccionado)) {
                    // Si el valor seleccionado en ComboBox2 está seleccionado en ComboBox1, mostrar un mensaje de error y deseleccionar el valor en ComboBox2
                    JOptionPane.showMessageDialog(null, "Este valor ya ha sido seleccionado en el otro ComboBox", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    comboBox2.setSelectedIndex(-1);
                }	
			}		
		};
		
		comboBox1.addActionListener(comboListener);
        comboBox2.addActionListener(comboListener);
	}
	
}
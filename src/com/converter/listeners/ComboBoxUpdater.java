package com.converter.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.converter.data.DataConverter;
import com.ui.UI;

public class ComboBoxUpdater implements ActionListener{
 	private DataConverter data;
 	private JComboBox<String> comboBoxFrom;
 	private JComboBox<String> comboBoxTo;
 	private JLabel iconConverter;

 	public ComboBoxUpdater(JComboBox<String> comboBoxFrom, JComboBox<String> comboBoxTo, JLabel iconConverter) {
        this.comboBoxFrom = comboBoxFrom;
        this.comboBoxTo = comboBoxTo;
        this.iconConverter = iconConverter;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			data = new DataConverter();
			JComboBox<String> comboBoxMain = (JComboBox<String>) e.getSource();

			//Se remueven los elementos de los comboBoxValueTo y comboBoxValueFrom
			//Se agregan los elementos correspondientes a los Comboboxes
			String conversorSeleccionado = (String) comboBoxMain.getSelectedItem();
			Map<String, List<String>> valoresMap = data.getValoresConversor();
			List<String> valoresList = valoresMap.get(conversorSeleccionado);

			// Borra todas las opciones del segundo ComboBox
	        comboBoxFrom.removeAllItems();
	        comboBoxTo.removeAllItems();

			for(String valor : valoresList) {
				comboBoxFrom.addItem(valor);
				comboBoxTo.addItem(valor);
			}
			
			switch (conversorSeleccionado) {
			case "Moneda": {
				iconConverter.setIcon(new ImageIcon(UI.class.getResource("/com/images/currency.png")));	
				break;
			}
			case "Temperatura": {
				iconConverter.setIcon(new ImageIcon(UI.class.getResource("/com/images/temperature.png")));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + conversorSeleccionado);
			}
		}

}

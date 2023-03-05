package com.converter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

public class ComboBoxUpdater implements ActionListener{
 	private DataConverter data = new DataConverter();
 	private JComboBox<String> comboBoxFrom;
 	private JComboBox<String> comboBoxTo;

 	public ComboBoxUpdater(JComboBox<String> comboBoxFrom, JComboBox<String> comboBoxTo) {
        this.comboBoxFrom = comboBoxFrom;
        this.comboBoxTo = comboBoxTo;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		}

}

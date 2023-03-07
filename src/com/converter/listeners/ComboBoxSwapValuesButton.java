package com.converter.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ComboBoxSwapValuesButton implements ActionListener {

    private JComboBox comboBoxFrom;
    private JComboBox comboBoxTo;

    public ComboBoxSwapValuesButton(JComboBox<?> comboBoxFrom, JComboBox<?> comboBoxTo) {
        this.comboBoxFrom = comboBoxFrom;
        this.comboBoxTo = comboBoxTo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object temp = comboBoxFrom.getSelectedItem();
        comboBoxFrom.setSelectedItem(comboBoxTo.getSelectedItem());
        comboBoxTo.setSelectedItem(temp);
    }
}
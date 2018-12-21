package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtonClear implements ActionListener {

	private JPanel panel;

	public ListenerButtonClear(JPanel panel) {

		this.panel = panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ListenerPanelDrawing.emptyPanel();
		panel.repaint();
	}
}

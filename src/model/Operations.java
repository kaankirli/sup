package model;

import controller.ListenerButtonClear;
import controller.ListenerPanelDrawing;
import view.PanelDrawing;

import javax.swing.*;

public class Operations {

	public void addListenerTo(JPanel panel) {
		ListenerPanelDrawing listenerPanelDrawing = new ListenerPanelDrawing(panel);
		panel.addMouseMotionListener(listenerPanelDrawing);
		panel.addMouseListener(listenerPanelDrawing);
	}

	public void addListenerTo(JButton button, JPanel panel) {
		PanelDrawing panelDrawing = (PanelDrawing) panel;
		button.addActionListener(new ListenerButtonClear(panelDrawing));
	}
}

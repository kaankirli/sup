package model;

import controller.ListenerPanelDrawing;
import view.ButtonClear;
import view.PanelDrawing;

import javax.swing.*;

public class Operations {

	public Operations(JPanel panel) {
		if (panel instanceof PanelDrawing) {
			ListenerPanelDrawing listenerPanelDrawing = new ListenerPanelDrawing(panel);
			panel.addMouseMotionListener(listenerPanelDrawing);
			panel.addMouseListener(listenerPanelDrawing);
		}
	}
}

package model;

import controller.ListenerPanelDrawing;
import view.ButtonClear;
import view.PanelDrawing;

import javax.swing.*;

public class Operations {

	public Operations(JPanel panel) {
		if (panel instanceof PanelDrawing)
			panel.addMouseMotionListener(new ListenerPanelDrawing(panel));
	}
}

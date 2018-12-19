package controller;

import view.ButtonColor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtonColor implements ActionListener {

	public static Color cursorColor = Color.BLACK;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof ButtonColor) {
			cursorColor = ((ButtonColor)e.getSource()).getBackground();
		}
	}
}

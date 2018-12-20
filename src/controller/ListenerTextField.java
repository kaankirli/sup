package controller;

import view.TextFieldBrushSize;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ListenerTextField implements MouseWheelListener {
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == -1) //Scroll up
			TextFieldBrushSize.setBrushSize(TextFieldBrushSize.getBrushSize() + 1);

		else if (e.getWheelRotation() == 1) //Scroll down
			TextFieldBrushSize.setBrushSize(TextFieldBrushSize.getBrushSize() - 1);

	}
}

package controller;

import view.TextFieldBrushSize;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ListenerTextField extends MouseAdapter {
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == -1) //Scroll up
			TextFieldBrushSize.setBrushSize(TextFieldBrushSize.getBrushSize() + 1);

		else if (e.getWheelRotation() == 1) //Scroll down
			TextFieldBrushSize.setBrushSize(TextFieldBrushSize.getBrushSize() - 1);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() instanceof TextFieldBrushSize)
			TextFieldBrushSize.getInstance().selectAll();
	}
}

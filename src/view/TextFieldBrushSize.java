package view;

import controller.ListenerTextField;

import javax.swing.*;

public class TextFieldBrushSize extends JTextField {

	private static TextFieldBrushSize brushSize = new TextFieldBrushSize();

	public static TextFieldBrushSize getInstance() {
		return brushSize;
	}

	private TextFieldBrushSize() {
		setHorizontalAlignment(RIGHT);
		setText("20");

		addMouseWheelListener(new ListenerTextField());
	}

	public static int getBrushSize() {
		String size = brushSize.getText();
		return Integer.parseInt(size);
	}
	
	public static void setBrushSize(int size) {
		if (size > 0 && size <= 200)
			brushSize.setText("" + size);
	}
}

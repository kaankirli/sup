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
		setText("30");

		addMouseWheelListener(new ListenerTextField());
	}

	public static int getBrushSize() {
		int size;
		try {
			size = Integer.parseInt(brushSize.getText());
			if (size < 1) {
				size = 1;
				brushSize.setText("1");
			} else if (size > 200) {
				size = 200;
				brushSize.setText("200");
			}
		} catch (Exception exception) {
			setBrushSize(30);
			size = 30;
		}
		return size;
	}
	
	public static void setBrushSize(int size) {
		if (size > 0 && size <= 200)
			brushSize.setText("" + size);
	}
}

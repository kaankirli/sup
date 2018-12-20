package view;

import javax.swing.*;

public class TextFieldBrushSize extends JTextField {

	private static TextFieldBrushSize brushSize = new TextFieldBrushSize();

	public static TextFieldBrushSize getInstance() {
		return brushSize;
	}

	private TextFieldBrushSize() {
		setText("20");
	}
	
	public static int getBrushSize() {
		String size = brushSize.getText();
		return Integer.parseInt(size);
	}
	
	public static void setBrushSize(int size) {
		brushSize.setText("" + size);
	}
}

package view;

import model.Operations;

import javax.swing.*;
import java.awt.Color;

public class PanelTop extends JPanel {

	private ButtonClear buttonClear;
	private Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};

	public PanelTop(PanelDrawing panelDrawing) {

		setLayout(null);
		setBounds(0, 0, getWidth(), 60);
		setBackground(Color.LIGHT_GRAY);

		buttonClear = new ButtonClear();

		int index = 0;
		for (Color color : colors) {
			ButtonColor buttonColor = new ButtonColor(color);
			buttonColor.setBounds(20 + (++index) * 30, 20, 20, 20);

			add(buttonColor);
		}

		TextFieldBrushSize.getInstance().setBounds(20 + (++index) * 30,
				20, 40, 20);
		buttonClear.setBounds(40 + (++index) * 30, 20, 70, 20);

		add(TextFieldBrushSize.getInstance());
		add(buttonClear);

		Operations operations = new Operations();
		operations.addListenerTo(buttonClear, panelDrawing);
	}
}

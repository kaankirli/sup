package view;

import model.Operations;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class PanelTop extends JPanel {

	private ButtonClear buttonClear;
	private ButtonCustomColor buttonCustomColor;
	private Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};

	public PanelTop(PanelDrawing panelDrawing) {

		setLayout(null);
		setBounds(0, 0, getWidth(), 60);
		setBackground(Color.LIGHT_GRAY);

		buttonClear = new ButtonClear();
		buttonCustomColor = new ButtonCustomColor();
		buttonCustomColor.addActionListener(e -> setColorSelectingFrame());

		int index = 0;
		for (Color color : colors) {
			ButtonColor buttonColor = new ButtonColor(color);
			buttonColor.setBounds(20 + (++index) * 30, 20, 20, 20);

			add(buttonColor);
		}

		TextFieldBrushSize.getInstance().setBounds(20 + (++index) * 30, 20, 40, 20);
		buttonClear.setBounds(40 + (++index) * 30, 20, 70, 20);

		add(TextFieldBrushSize.getInstance());
		add(buttonClear);

        ButtonPickImage buttonPickImage = new ButtonPickImage();
        buttonPickImage.setBounds(90 + (++index) * 30, 20, 120, 20);
        add(buttonPickImage);

		Operations operations = new Operations();
		operations.addListenerTo(buttonClear, panelDrawing);
		
		buttonCustomColor.setBounds(190 + (++index) * 30, 20, 120, 20);
		add(buttonCustomColor);
	}
	
	private void setColorSelectingFrame() {
		JFrame frame = new JFrame("Color Select");
		JPanel topPanel = new JPanel();
		JButton saveColor = new JButton("Save Color");
		JColorChooser colorChooser = new JColorChooser();
		topPanel.add(saveColor);
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(colorChooser);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

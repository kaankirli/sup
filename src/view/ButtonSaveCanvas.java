package view;

import controller.ListenerButtonSaveCanvas;

import javax.swing.*;
import java.awt.*;


public class ButtonSaveCanvas extends JButton {
	public ButtonSaveCanvas(JPanel panel) {
		setText("Save");
		setBackground(Color.white);
		ListenerButtonSaveCanvas listener = new ListenerButtonSaveCanvas();
		listener.setCanvas(panel);
		addActionListener(listener);
		setMargin(new Insets(0,0,0,0));
	}
}

package view;

import controller.ListenerButtonLoadImage;
import controller.ListenerButtonSaveCanvas;

import javax.swing.*;
import java.awt.*;

public class ButtonLoadImage extends JButton {

	public ButtonLoadImage(JPanel panel) {
		setText("Load");
		setBackground(Color.WHITE);
		addActionListener(new ListenerButtonLoadImage(panel));
		setMargin(new Insets(0,0,0,0));
	}
}

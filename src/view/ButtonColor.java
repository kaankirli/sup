package view;

import controller.ListenerButtonColor;

import javax.swing.*;
import java.awt.*;

public class ButtonColor extends JButton {

	public ButtonColor(Color color) {

		setBackground(color);
		addActionListener(new ListenerButtonColor());

	}

}

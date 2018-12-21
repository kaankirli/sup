package view;

import controller.ListenerButtonChooseCursor;
import javax.swing.*;
import java.awt.*;

public class ButtonChooseCursor extends JButton {

	public ButtonChooseCursor() {
		setText("Choose Cursor");
		setBackground(Color.white);
		addActionListener(new ListenerButtonChooseCursor());
		setMargin(new Insets(0,0,0,0));
	}
}

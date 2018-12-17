package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelDrawing extends JPanel {

	private BufferedImage bufferedImage;

	public PanelDrawing() {
		setLayout(null);
		setBackground(Color.WHITE);
		JButton button = new JButton();
		button.setBounds(10,10,100,100);
		add(button, 0);
	}

	public void setImage(BufferedImage bufferedImage) {

		this.bufferedImage = bufferedImage;

	}

	public void paint(Graphics g) {
		try {
			g.drawImage(bufferedImage, 0, 0, this);
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		}
	}
}

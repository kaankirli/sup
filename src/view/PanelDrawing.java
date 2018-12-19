package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelDrawing extends JPanel {

	private BufferedImage bufferedImage;

	public PanelDrawing() {
		setLayout(null);
		setBackground(Color.WHITE);
	}

	public void setImage(BufferedImage bufferedImage) {

		this.bufferedImage = bufferedImage;

	}

	@Override
	public void paint(Graphics g) {
		try {
			g.drawImage(bufferedImage, 0, 0, this);
		} catch(NullPointerException npe) {
			npe.printStackTrace();
		}
	}
}

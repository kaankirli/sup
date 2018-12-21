package view;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HelperImageBrush {

	public static BufferedImage setSize(BufferedImage bufferedImage, int size) {
		Image temp = bufferedImage.getScaledInstance(size, size, Image.SCALE_SMOOTH);
		BufferedImage newImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = newImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();

		return newImage;
	}
}

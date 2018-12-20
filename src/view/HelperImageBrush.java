package view;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class HelperImageBrush {

	public static BufferedImage readBrushFromFile(String pathName) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(pathName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bufferedImage;
	}

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

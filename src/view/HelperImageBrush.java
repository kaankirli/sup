package view;

import controller.ListenerButtonColor;

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

	public static BufferedImage paintFromBrush(BufferedImage cursor) {
		int[][] pixels = new int[cursor.getWidth()][cursor.getHeight()];


		Color color = ListenerButtonColor.cursorColor;

		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = cursor.getRGB(i, j);
			}
		}

		BufferedImage paint = new BufferedImage(cursor.getWidth(), cursor.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[0].length; j++) {
				if (isInBrush(i, j, pixels))
					paint.setRGB(i, j, color.getRGB());
			}
		}

		return paint;
	}

	private static boolean isInBrush(int x, int y, int[][] pixels) {
		boolean[] didItFind = {false, false, false, false};

		for (int i = x; i < pixels.length; i++) {
			if (pixels[i][y] != 0) {
				didItFind[0] = true;
				break;
			}
		}

		if (!didItFind[0])
			return false;

		for (int i = 0; i < x; i++) {
			if (pixels[i][y] != 0) {
				didItFind[1] = true;
				break;
			}
		}

		if (!didItFind[1])
			return false;

		for (int i = y; i < pixels[0].length; i++) {
			if (pixels[x][i] != 0) {
				didItFind[2] = true;
				break;
			}
		}

		if (!didItFind[2])
			return false;

		for (int i = 0; i < y; i++) {
			if (pixels[x][i] != 0) {
				didItFind[3] = true;
				break;
			}
		}

		if (!didItFind[3])
			return false;


		return true;
	}
}

package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class PanelBrush extends JPanel {

	private int size = 20;

	public PanelBrush() {
		this.setBounds(0, 0, size, size);
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BufferedImage createImage() {

		int w = size;
		int h = size;
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		this.paint(g);
		g.dispose();
		return bi;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawOval(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
}

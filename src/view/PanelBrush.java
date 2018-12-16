package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PanelBrush extends JPanel {

	private int size;
	private Color color;

	public PanelBrush(int size, Color color) {
		this.size = size;
		this.color = color;
		this.setBounds(0, 0, size, size);
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void paintComponent(Graphics g) {
		g.setColor(color);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawOval(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
}

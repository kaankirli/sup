package controller;

import view.PanelBrush;
import view.PanelDrawing;
import view.TextFieldBrushSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ListenerPanelDrawing extends MouseAdapter {

	private int brushSize;
	private static PanelDrawing panelDrawing;
	private static Graphics graphics;
	private PanelBrush panelBrush;

	private JPanel testPanel;

	public ListenerPanelDrawing(JPanel panel) {
		if (panel instanceof PanelDrawing) {

			panelDrawing = (PanelDrawing) panel;

			BufferedImage bufferedImage = new BufferedImage(panelDrawing.getWidth(), panelDrawing.getHeight(), BufferedImage.TYPE_INT_RGB);
			panelDrawing.setImage(bufferedImage);

			graphics = bufferedImage.getGraphics();
			((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, panelDrawing.getWidth(), panelDrawing.getHeight());

			panelBrush = new PanelBrush(brushSize, Color.GRAY);

			testPanel = new JPanel() {

				public void paintComponent(Graphics g) {
					g.setColor(Color.GRAY);
					((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g.drawOval(0, 0, 20, 20);
				}
			};

			panelDrawing.add(testPanel, 0);

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		brushSize = Integer.parseInt(TextFieldBrushSize.getInstance().getText());
		panelBrush.setLocation(e.getX() - brushSize / 2,
				e.getY() - brushSize / 2);
		panelBrush.setSize(brushSize);
		panelDrawing.add(panelBrush, 0);
		panelDrawing.repaint();
		testPanel.setBounds(300, 300, 20, 20);
		panelDrawing.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		graphics.setColor(Color.BLACK);
		graphics.fillOval(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
		panelDrawing.repaint();
	}
}

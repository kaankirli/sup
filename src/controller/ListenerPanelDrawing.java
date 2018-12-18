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

	private static final PanelBrush PANEL_BRUSH = new PanelBrush();

	private static int brushSize;
	private static PanelDrawing panelDrawing;
	private static Graphics graphics;
	private Cursor brushCursor;

	public ListenerPanelDrawing(JPanel panel) {
		if (panel instanceof PanelDrawing) {

			panelDrawing = (PanelDrawing) panel;

			BufferedImage bufferedImage = new BufferedImage(panelDrawing.getWidth(), panelDrawing.getHeight(), BufferedImage.TYPE_INT_RGB);
			panelDrawing.setImage(bufferedImage);

			graphics = bufferedImage.getGraphics();
			((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, panelDrawing.getWidth(), panelDrawing.getHeight());

		}
	}

	public static void emptyPanel() {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, panelDrawing.getWidth(), panelDrawing.getHeight());

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		brushSize = Integer.parseInt(TextFieldBrushSize.getInstance().getText());
		PANEL_BRUSH.setSize(brushSize);
		brushCursor = Toolkit.getDefaultToolkit().createCustomCursor(PANEL_BRUSH.createImage(), new Point(brushSize / 2, brushSize / 2), "brush cursor");
		panelDrawing.setCursor(brushCursor);
		panelDrawing.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		graphics.setColor(Color.BLACK);
		graphics.fillOval(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
		panelDrawing.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		graphics.setColor(Color.BLACK);
		graphics.fillOval(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
		panelDrawing.repaint();
	}
}

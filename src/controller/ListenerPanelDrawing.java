package controller;

import view.HelperImageBrush;
import view.PanelDrawing;
import view.TextFieldBrushSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ListenerPanelDrawing extends MouseAdapter {

	private static int brushSize;
	private static PanelDrawing panelDrawing;
	private static Graphics graphics;
	private static BufferedImage cursorImage;
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

	public static Graphics getGraphics() {
		return graphics;
	}

	public static void emptyPanel() {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, panelDrawing.getWidth(), panelDrawing.getHeight());

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		brushSize = TextFieldBrushSize.getBrushSize();
		cursorImage = ListenerButtonImportCursor.getBrushImage();
		cursorImage = HelperImageBrush.setSize(cursorImage, brushSize);
		brushCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(brushSize / 2, brushSize / 2), "brush cursor");
		panelDrawing.setCursor(brushCursor);
		panelDrawing.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			graphics.drawImage(HelperImageBrush.paintFromBrush(cursorImage), e.getX() - brushSize / 2, e.getY() - brushSize / 2, panelDrawing);
			panelDrawing.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			graphics.drawImage(HelperImageBrush.paintFromBrush(cursorImage), e.getX() - brushSize / 2, e.getY() - brushSize / 2, panelDrawing);
			panelDrawing.repaint();
		}
	}
}

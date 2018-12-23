package controller;

import view.ButtonLoadImage;
import view.PanelDrawing;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListenerButtonLoadImage implements ActionListener {

	private JPanel panel;

	public ListenerButtonLoadImage(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof ButtonLoadImage && panel instanceof PanelDrawing) {

			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			FileFilter imageFilter = new FileNameExtensionFilter(
					"Image files", ImageIO.getReaderFileSuffixes());
			fileChooser.setFileFilter(imageFilter);


			int returnValue = fileChooser.showOpenDialog(null);

			File selectedFile = null;
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();
			}

			BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(selectedFile);
			} catch (IOException exception) {
				exception.printStackTrace();
			}

			ListenerPanelDrawing.getGraphics().drawImage(bufferedImage, 0, 0, panel);
		}
	}
}

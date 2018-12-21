package controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ListenerButtonChooseCursor implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src/brushes/");
		FileFilter imageFilter = new FileNameExtensionFilter(
				"Image files", ImageIO.getReaderFileSuffixes());
		fileChooser.setFileFilter(imageFilter);
		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			ListenerButtonImportCursor.setCursorFileName(selectedFile.getName());
		}
	}
}

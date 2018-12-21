package controller;

import view.ButtonPickImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.imageio.*;
import org.apache.commons.io.*;

public class ListenerButtonPickImage implements ActionListener {


	//System.getProperty("user.dir") + "/src/brushes"

	private static BufferedImage brushImage;
	private static String pathName = System.getProperty("user.dir") + "/src/brushes/";
	private static String cursorFileName = "default_cursor.png";

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof ButtonPickImage) {

			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			FileFilter imageFilter = new FileNameExtensionFilter(
					"Image files", ImageIO.getReaderFileSuffixes());
			fileChooser.setFileFilter(imageFilter);


			int returnValue = fileChooser.showOpenDialog(null);
			// int returnValue = jfc.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());

				try {
					FileUtils.copyFileToDirectory(selectedFile, new File(pathName));
					cursorFileName = selectedFile.getName();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static BufferedImage getBrushImage(){
		try {
			brushImage = ImageIO.read(new File(pathName + cursorFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return brushImage;
	}
}

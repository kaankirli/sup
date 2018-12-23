package controller;

import view.ButtonImportCursor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.imageio.*;
import org.apache.commons.io.*;

public class ListenerButtonImportCursor implements ActionListener {

	private static BufferedImage brushImage;
	private static String pathName = System.getProperty("user.dir") + "/src/brushes/";
	private static String cursorFileName = "default_cursor.png";

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof ButtonImportCursor) {

			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			FileFilter imageFilter = new FileNameExtensionFilter(
					"Image files", ImageIO.getReaderFileSuffixes());
			fileChooser.setFileFilter(imageFilter);


			int returnValue = fileChooser.showOpenDialog(null);

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

	public static void setCursorFileName(String name) {
		cursorFileName = name;
	}

	public static BufferedImage getBrushImage(){
		try {
			brushImage = ImageIO.read(new File(pathName + cursorFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

			ImageFilter filter = new GrayFilter(true, 0);
			ImageProducer producer = new FilteredImageSource(brushImage.getSource(), filter);
			Image grayBrush = Toolkit.getDefaultToolkit().createImage(producer);

			brushImage = new BufferedImage(grayBrush.getWidth( null), grayBrush.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			brushImage.getGraphics().drawImage(grayBrush, 0, 0, null);

		return brushImage;
	}
}

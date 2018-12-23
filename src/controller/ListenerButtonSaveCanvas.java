package controller;

import view.ButtonSaveCanvas;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ListenerButtonSaveCanvas implements ActionListener {

	private static String pathName = System.getProperty("user.dir") + "/src/images/";
	private JPanel canvas;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof ButtonSaveCanvas) {
			saveImage(canvas);
		}
	}

	public void setCanvas(JPanel canvas) {
		this.canvas = canvas;
	}

	public void saveImage(JPanel canvas) {
		BufferedImage imagebuf = null;
		try {
			imagebuf = new Robot().createScreenCapture(canvas.getVisibleRect());
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		Graphics2D graphics2D = imagebuf.createGraphics();
		canvas.paint(graphics2D);

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String dateString = dateFormat.format(date);

		//Default save path -- Old solution
        /*
		File file = new File(pathName);
		boolean exists = file.exists();
		if (!exists) {

			file.mkdirs();
		}
        */

		//Directory Chooser
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {

			try {

				ImageIO.write(imagebuf, "jpeg", new File(fileChooser.getSelectedFile().getAbsolutePath() + "/" + dateString + ".jpeg"));
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		//


	}
}
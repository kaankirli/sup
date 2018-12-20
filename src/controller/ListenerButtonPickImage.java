package controller;

import view.ButtonColor;
import view.ButtonPickImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.imageio.*;



public class ListenerButtonPickImage implements ActionListener {


    BufferedImage brushImage;

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
                    BufferedImage img = ImageIO.read(selectedFile);
                    brushImage = img;
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }



            }
           // brushImage = new BufferedImage()


        }
    }


}

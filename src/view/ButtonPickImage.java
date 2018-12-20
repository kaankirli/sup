package view;


import controller.ListenerButtonPickImage;
import javax.swing.*;
import java.awt.*;


public class ButtonPickImage extends JButton {

    public ButtonPickImage () {
        setText("Pick Image");
        setBackground(Color.white);
        addActionListener(new ListenerButtonPickImage());
    }


}

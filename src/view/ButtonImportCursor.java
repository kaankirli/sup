package view;


import controller.ListenerButtonImportCursor;
import javax.swing.*;
import java.awt.*;


public class ButtonImportCursor extends JButton {

    public ButtonImportCursor() {
        setText("Import Cursor");
        setBackground(Color.white);
        addActionListener(new ListenerButtonImportCursor());
        setMargin(new Insets(0,0,0,0));
    }


}

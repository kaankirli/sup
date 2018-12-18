package view;

import model.Operations;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class FrameMain extends JFrame {

	private PanelDrawing panelDrawing;
	private PanelTop panelTop;

	public FrameMain() {

		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		panelDrawing = new PanelDrawing();
		panelTop = new PanelTop(panelDrawing);

		panelDrawing.setBounds(0, panelTop.getHeight(), getWidth(), getHeight() - panelTop.getHeight());
		panelTop.setBounds(0, 0, getWidth(), 60);

		add(panelDrawing);
		add(panelTop);

		Operations operations = new Operations();
		operations.addListenerTo(panelDrawing);

	}
	public void setBrushSize(int size) {
        	panelBrush.setSBrushSize(size);}

    	public int getBrushSize(){
       		return panelBrush.getBrushSize();
    }
}

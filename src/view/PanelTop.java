package view;

import model.Operations;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import SQLConnection.SQLiteConnection;
import controller.ListenerButtonColor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class PanelTop extends JPanel {

	private ButtonClear buttonClear;
	private ButtonCustomColor buttonCustomColor;
	private Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
	HashMap<String, Color> customColors;

	public PanelTop(PanelDrawing panelDrawing) {

		setLayout(null);
		setBounds(0, 0, getWidth(), 60);
		setBackground(Color.LIGHT_GRAY);

		buttonClear = new ButtonClear();
		buttonCustomColor = new ButtonCustomColor();
		buttonCustomColor.addActionListener(e -> setColorSelectingFrame());

		int index = 0;
		for (Color color : colors) {
			ButtonColor buttonColor = new ButtonColor(color);
			buttonColor.setBounds(20 + (++index) * 30, 20, 20, 20);

			add(buttonColor);
		}

		TextFieldBrushSize.getInstance().setBounds(20 + (++index) * 30, 20, 40, 20);
		buttonClear.setBounds(40 + (++index) * 30, 20, 70, 20);

		add(TextFieldBrushSize.getInstance());
		add(buttonClear);

        ButtonImportCursor buttonImportCursor = new ButtonImportCursor();
        buttonImportCursor.setBounds(90 + (++index) * 30, 20, 120, 20);
        add(buttonImportCursor);

		ButtonChooseCursor buttonChooseCursor = new ButtonChooseCursor();
		buttonChooseCursor.setBounds(190 + (++index) * 30, 20, 120, 20);
		add(buttonChooseCursor);

		buttonCustomColor.setBounds(290 + (++index) * 30, 20, 120, 20);
		add(buttonCustomColor);

		Operations operations = new Operations();
		operations.addListenerTo(buttonClear, panelDrawing);
	}
	
	private void setColorSelectingFrame() {
		JFrame customColorFrame = new JFrame("Custom Color");
		JPanel topPanel = new JPanel();
		JButton saveColor = new JButton("Save Color");
		JButton selectCustomColor = new JButton("Select Custom Color");
		JButton deleteCustomColor = new JButton("Delete Custom Color");
		JColorChooser colorChooser = new JColorChooser();
		colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				ListenerButtonColor.cursorColor = colorChooser.getColor();
			}
		});
		
		saveColor.addActionListener(e -> saveColorClicked(colorChooser.getColor()));
		selectCustomColor.addActionListener(e -> selectCustomColorClicked());
		deleteCustomColor.addActionListener(e -> deleteCustomColor());
		
		topPanel.add(saveColor);
		topPanel.add(selectCustomColor);
		topPanel.add(deleteCustomColor);
		customColorFrame.add(topPanel, BorderLayout.NORTH);
		customColorFrame.add(colorChooser);
		customColorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		customColorFrame.pack();
		customColorFrame.setLocationRelativeTo(null);
		customColorFrame.setVisible(true);
	}
	
	private void saveColorClicked(Color color) {
		try {
			String name = JOptionPane.showInputDialog(null, "Enter the name of your color.", "Info", JOptionPane.OK_CANCEL_OPTION);
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			int alpha = color.getAlpha();
			if (!name.isEmpty()) {
				SQLiteConnection connection = (SQLiteConnection) SQLiteConnection.getInstance();
				connection.saveColor(red, green, blue, alpha, name);
			} else {
				JOptionPane.showMessageDialog(null, "Please enter a name!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		} catch (NullPointerException e) { }
	}
	
	private void selectCustomColorClicked() {
		JFrame selectColorFrame = new JFrame("Select Custom Color");
		selectColorFrame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.insets = new Insets(2, 2, 2, 2);
		customColors = SQLiteConnection.getInstance().getColorsMap();
		
		for (int i = 0; i < customColors.size(); ++i) {
			JLabel colorLable = new JLabel(customColors.keySet().toArray()[i].toString());
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			colorLable.setBorder(border);
			colorLable.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					Color color = customColors.get(colorLable.getText());
					ListenerButtonColor.cursorColor = color;
					selectColorFrame.dispose();
				}
			});
			selectColorFrame.add(colorLable, gbc);
			gbc.gridy++;
		}
		
		selectColorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		selectColorFrame.pack();
		selectColorFrame.setLocationRelativeTo(null);
		selectColorFrame.setVisible(true);
	}
	
	private void deleteCustomColor() {
		try {
			String colorName = JOptionPane.showInputDialog(null, "Enter the name of your color.", "Delete Color", JOptionPane.OK_CANCEL_OPTION);
			if (!colorName.isEmpty()) {
				SQLiteConnection connection = (SQLiteConnection) SQLiteConnection.getInstance();
				connection.deleteColor(colorName);
			} else {
				JOptionPane.showMessageDialog(null, "Please enter a name!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		} catch (NullPointerException e) { }
	}
	
}

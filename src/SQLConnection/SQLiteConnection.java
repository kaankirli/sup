package SQLConnection;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class SQLiteConnection {

	private static SQLiteConnection SQLITE = null;
	private static Connection CONNECTION = null;
	private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "/src/Colors.db";

	private SQLiteConnection() {
		try {
			CONNECTION = DriverManager.getConnection(URL);
			System.out.println("Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static SQLiteConnection getInstance() {
		if (SQLITE == null) {
			SQLITE = new SQLiteConnection();
			return SQLITE;
		} else
			return SQLITE;
	}

	public void saveColor(int red, int green, int blue, int alpha, String name) {
		String query = "INSERT INTO custom_colors VALUES(" + red + "," + green + "," + blue + "," + alpha + "," + "'"
				+ name + "'" + ")";
		try {
			Statement statement = CONNECTION.createStatement();
			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Color " + name + " added successfully", "Info",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getColors() {
		String query = "SELECT * FROM custom_colors";
		try {
			Statement statement = CONNECTION.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("Red: " + resultSet.getInt(1)
							 + ", Green: " + resultSet.getInt(2)
							 + ", Blue: "  + resultSet.getInt(3)
							 + ", Alpha: " + resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Color> getColorsMap() {
		HashMap<String, Color> colors = new HashMap<String, Color>();
		String query = "SELECT * FROM custom_colors";
		try {
			Statement statement = CONNECTION.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int red = resultSet.getInt(1);
				int green = resultSet.getInt(2);
				int blue = resultSet.getInt(3);
				int alpha = resultSet.getInt(3);
				String colorName = resultSet.getString(5);
				Color color = new Color(red, green, blue, alpha);
				colors.put(colorName, color);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colors;
	}
	
	public void deleteColor(String colorName) {
		String query = "DELETE FROM custom_colors WHERE name='" + colorName + "';";
		try {
			Statement statement = CONNECTION.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLiteConnection {

	private static SQLiteConnection SQLITE = null;
	private static Connection CONNECTION = null;
	private static final String URL = "jdbc:sqlite:Colors.db";

	private SQLiteConnection() {
		try {
			CONNECTION = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connected");
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
			statement.executeQuery(query);
			JOptionPane.showMessageDialog(null, "Color " + name + " added successfully", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

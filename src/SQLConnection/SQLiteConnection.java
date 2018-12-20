package SQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
	
	private static Connection CONNECTION = null;
	private static final String URL = "jdbc:sqlite:Colors.db";
	
	private SQLiteConnection() {
		
	}
	
	public static Connection getInstance() {
		if (CONNECTION == null) {
			try {
				CONNECTION = DriverManager.getConnection(URL);
				System.out.println("Connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return CONNECTION;
		}
		else
			return CONNECTION;
	}
	
	

}

package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.FrameMain;
import view.TextFieldBrushSize;
import static org.junit.Assert.*;
import SQLConnection.SQLiteConnection;

public class SupTest {

	static FrameMain frameMain;

	@BeforeAll
	public static void onceExecutedBeforeAll() {
		frameMain = new FrameMain();
	}

	@Test
	public void frameMainTest01() {
		assertNotNull(frameMain);
	}

	@Test
	public void getBrushSizeTest01() {
		int size = TextFieldBrushSize.getBrushSize();
		assertEquals(30, size);
	}

	@Test
	public void setBrushSizeTest01() {
		TextFieldBrushSize.setBrushSize(10);
		int size = TextFieldBrushSize.getBrushSize();
		assertEquals(10, size);
	}

	@Test
	public void databaseConnectionTest() {
		SQLiteConnection connection = SQLiteConnection.getInstance();
		assertNotNull(connection);
	}
	
	@Test
	public void listTablesTest() {
		SQLiteConnection connection = SQLiteConnection.getInstance();
		connection.getColors();
	}
	
	@Test
	public void colorExistsTest01() {
		SQLiteConnection connection = SQLiteConnection.getInstance();
		connection.saveColor(100, 150, 100, 255, "TestColor");
		boolean exists = connection.colorExists("TestColor");
		assertTrue(exists);
		connection.deleteColor("TestColor");
	}
	
	@Test
	public void colorExistsTest02() {
		SQLiteConnection connection = SQLiteConnection.getInstance();
		boolean exists = connection.colorExists("colorName");
		assertFalse(exists);
	}
	
}

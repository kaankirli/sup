package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.FrameMain;
import view.TextFieldBrushSize;
import static org.junit.Assert.*;

import java.awt.Color;

import SQLConnection.SQLiteConnection;

public class SupTest {

	static FrameMain frameMain;
	static SQLiteConnection connection;

	@BeforeAll
	public static void onceExecutedBeforeAll() {
		frameMain = new FrameMain();
		connection = SQLiteConnection.getInstance();
	}
	
	@AfterAll
	public static void onceExecutedAfterAll() {
		connection.disconnect();
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
		assertNotNull(connection);
	}
	
	@Test
	public void listTablesTest() {
		connection.getColors();
	}
	
	@Test
	public void saveColorTest01() {
		connection.saveColor(100, 100, 100, 100, "testColor");
		Color color = connection.getColor("testColor");
		assertEquals(100, color.getRed());
		assertEquals(100, color.getGreen());
		assertEquals(100, color.getBlue());
		assertEquals(100, color.getAlpha());
		connection.deleteColor("testColor");
	}
	
	@Test
	public void saveColorTest02() {
		connection.saveColor(43, 10, 29, 200, "testColor");
		Color color = connection.getColor("testColor");
		assertEquals(43, color.getRed());
		assertEquals(10, color.getGreen());
		assertEquals(29, color.getBlue());
		assertEquals(200, color.getAlpha());
		connection.deleteColor("testColor");
	}
	
	@Test
	public void colorExistsTest01() {
		connection.saveColor(100, 150, 100, 255, "TestColor");
		boolean exists = connection.colorExists("TestColor");
		assertTrue(exists);
		connection.deleteColor("TestColor");
	}
	
	@Test
	public void colorExistsTest02() {
		boolean exists = connection.colorExists("colorName");
		assertFalse(exists);
	}
	
	
	
}

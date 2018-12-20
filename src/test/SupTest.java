package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.FrameMain;
import view.TextFieldBrushSize;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.Statement;

import org.junit.*;
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
		assertEquals(20, size);
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
		connection.getTables();
	}
	
}

package test;

import org.junit.jupiter.api.Test;
import view.FrameMain;
import view.TextFieldBrushSize;
import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.*;

import SQLConnection.SQLiteConnection;

public class SupTest {

	static FrameMain frameMain;

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		frameMain = new FrameMain();
	}

	@Test
	public void frameMainTest01() {
		assertEquals(500, frameMain.getHeight());
		assertEquals(1000, frameMain.getWidth());
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
		Connection connection = SQLiteConnection.getInstance();
		assertNotNull(connection);
	}


}
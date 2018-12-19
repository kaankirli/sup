package test;

import view.FrameMain;
import view.TextFieldBrushSize;
import static org.junit.Assert.*;
import org.junit.*;

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
		int size = TextFieldBrushSize.getInstance().getBrushSize();
		assertEquals(20, size);
	}
	
	@Test
	public void setBrushSizeTest01() {
		TextFieldBrushSize.getInstance().setBrushSize(10);
		int size = TextFieldBrushSize.getInstance().getBrushSize();
		assertEquals(10, size);
	}
	
	
}
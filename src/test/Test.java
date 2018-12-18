package test;

import controller.ListenerPanelDrawing;
import org.junit.Test;
import static org.junit.Assert.*;


public class CUPTest {

    @Test
    public void testWindowSize() {
        FrameMain frameMain = new FrameMain();
        assertEquals(500, frameMain.getHeight());
        assertEquals(1000, frameMain.getWidth());

    }
    @Test
    public void testBrushSizeInit() {
        FrameMain frameMain = new FrameMain();
        assertEquals(20, frameMain.getBrushSize());

    }
    @Test
    public void testBrushSizeSetter() {
        FrameMain frameMain = new FrameMain();
        frameMain.setBrushSize(10);
        assertEquals(10, frameMain.getBrushSize());

    }
}

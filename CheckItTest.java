import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CheckItTest {
    @Test
    public void testCheckItTrue() {
        // Test when a is true
        assertTrue(runCheckIt(true, false, false));
        assertTrue(runCheckIt(true, true, false));
        assertTrue(runCheckIt(true, true, true));
    }
    
    @Test
    public void testCheckItFalse() {
        // Test when a is false and b, c are false
        assertFalse(runCheckIt(false, false, false));
        // Test when a is false, b is true, and c is false
        assertFalse(runCheckIt(false, true, false));
        // Test when a is false, b is false, and c is true
        assertFalse(runCheckIt(false, false, true));
        // Test when a is false, b is true, and c is true
        assertFalse(runCheckIt(false, true, true));
    }

    private boolean runCheckIt(boolean a, boolean b, boolean c) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(a, b, c);

        String output = outContent.toString().trim();

        System.setOut(System.out);

        return output.equals("P is true");
    }
}

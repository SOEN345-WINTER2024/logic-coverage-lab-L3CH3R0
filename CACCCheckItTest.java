import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CACCCheckItTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testAMakesDifference() {
        CheckIt.checkIt(false, true, true); // a is false, b && c is true
        assertEquals("P is true\n", outContent.toString().trim());
        outContent.reset();
        
        CheckIt.checkIt(true, false, true); // Changing a to true, keeping b && c true as control
        assertEquals("P is true\n", outContent.toString().trim());
    }

    @Test
    public void testBMakesDifference() {
        CheckIt.checkIt(false, false, true); // a is false, b is false, c is true
        assertEquals("P isn't true\n", outContent.toString().trim());
        outContent.reset();
        
        CheckIt.checkIt(false, true, true); // Changing b to true, keeping a false and c true
        assertEquals("P is true\n", outContent.toString().trim());
    }

    @Test
    public void testCMakesDifference() {
        CheckIt.checkIt(false, true, false); // a is false, b is true, c is false
        assertEquals("P isn't true\n", outContent.toString().trim());
        outContent.reset();
        
        CheckIt.checkIt(false, true, true); // Changing c to true, keeping a false and b true
        assertEquals("P is true\n", outContent.toString().trim());
    }
}

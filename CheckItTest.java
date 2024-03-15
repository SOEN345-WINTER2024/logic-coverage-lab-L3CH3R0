import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckItTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // Setup method to redirect System.out to capture the output
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    // Cleanup method to restore System.out
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testAIsTrue() {
        setUpStreams();
        CheckIt.checkIt(true, false, false); // Only a is true
        assertEquals("P is true\n", outContent.toString());
        cleanUpStreams();
    }

    @Test
    public void testBAndCIsTrue() {
        setUpStreams();
        CheckIt.checkIt(false, true, true); // Both b and c are true, a is false
        assertEquals("P is true\n", outContent.toString());
        cleanUpStreams();
    }

    @Test
    public void testAllFalse() {
        setUpStreams();
        CheckIt.checkIt(false, false, false); // All are false
        assertEquals("P isn't true\n", outContent.toString());
        cleanUpStreams();
    }

    @Test
    public void testAllTrue() {
        setUpStreams();
        CheckIt.checkIt(true, true, true); // All are true
        assertEquals("P is true\n", outContent.toString());
        cleanUpStreams();
    }
}

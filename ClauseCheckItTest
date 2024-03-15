import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ClauseCheckItTest {

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
    public void whenAIsTrue() {
        CheckIt.checkIt(true, false, false); // a is true, making the whole expression true
        assertEquals("P is true\n", outContent.toString().trim());
    }

    @Test
    public void whenAIsFalseAndBandCAreFalse() {
        outContent.reset();
        CheckIt.checkIt(false, false, false); // a is false, b and c are false
        assertEquals("P isn't true\n", outContent.toString().trim());
    }

    @Test
    public void whenAIsFalseAndBIsTrueAndCIsFalse() {
        outContent.reset();
        CheckIt.checkIt(false, true, false); // b is true, c is false, making b && c false
        assertEquals("P isn't true\n", outContent.toString().trim());
    }

    @Test
    public void whenAIsFalseAndBIsFalseAndCIsTrue() {
        outContent.reset();
        CheckIt.checkIt(false, false, true); // b is false, c is true, making b && c false
        assertEquals("P isn't true\n", outContent.toString().trim());
    }

    @Test
    public void whenAIsFalseAndBandCAreTrue() {
        outContent.reset();
        CheckIt.checkIt(false, true, true); // Both b and c are true, making b && c true
        assertEquals("P is true\n", outContent.toString().trim());
    }
}

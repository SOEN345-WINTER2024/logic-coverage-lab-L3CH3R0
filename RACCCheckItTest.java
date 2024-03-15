import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckItTest {

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
    public void whenAIsPivotal() {
        CheckIt.checkIt(false, false, false); // a is false, b && c is false, outcome is false
        assertEquals("P isn't true\n", outContent.toString().trim());
        outContent.reset();
        
        CheckIt.checkIt(true, false, false); // Changing a to true, b && c remains false, outcome changes to true
        assertEquals("P is true\n", outContent.toString().trim());
    }

    @Test
    public void whenBIsPivotal() {
        CheckIt.checkIt(false, false, true); // a is false, b is false, c is true, outcome is false
        assertEquals("P isn't true\n", outContent.toString().trim());
        outContent.reset();
        
        CheckIt.checkIt(false, true, true); // a is false, changing b to true (with c true), outcome changes to true
        assertEquals("P is true\n", outContent.toString().trim());
    }

    @Test
    public void whenCIsPivotal() {
        CheckIt.checkIt(false, true, false); // a is false, b is true, c is false, outcome is false
        assertEquals("P isn't true\n", outContent.toString().trim());
        outContent.reset();
        
        CheckIt.checkIt(false, true, true); // a is false, b is true, changing c to true, outcome changes to true
        assertEquals("P is true\n", outContent.toString().trim());
    }
}

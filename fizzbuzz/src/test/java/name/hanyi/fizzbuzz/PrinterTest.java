package name.hanyi.fizzbuzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrinterTest {

    Printer printer;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        printer = new Printer();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void printNumberSequenceConvertedIntoFizzBuzz() {
        printer.print(1, 5);

        assertThat(outContent.toString(), is("1\n2\nFizz\n4\nBuzz\n"));
    }
}

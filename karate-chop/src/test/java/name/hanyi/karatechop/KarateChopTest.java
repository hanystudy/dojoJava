package name.hanyi.karatechop;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class KarateChopTest {

    private KarateChop chop;

    @Before
    public void setUp() {
        chop = new KarateChop();
    }

    @Test
    public void testChop() {
        final int[] inputArray = {1, 3, 5, 7, 9, 11};
        assertEquals(0, chop.chop(1, inputArray));
        assertEquals(1, chop.chop(3, inputArray));
        assertEquals(2, chop.chop(5, inputArray));
        assertEquals(3, chop.chop(7, inputArray));
        assertEquals(4, chop.chop(9, inputArray));
        assertEquals(5, chop.chop(11, inputArray));
        assertEquals(-1, chop.chop(2, inputArray));
    }

    @Test
    public void testLargeDataSetUsingCharacterReader() throws IOException, URISyntaxException {
        URL resourceURL = KarateChopTest.class.getClassLoader().getResource("sample.txt");
        Path path = Paths.get(resourceURL.toURI());
        assertEquals(499, chop.chopFile(500, path));
        assertEquals(997, chop.chopFile(999, path));
    }
}
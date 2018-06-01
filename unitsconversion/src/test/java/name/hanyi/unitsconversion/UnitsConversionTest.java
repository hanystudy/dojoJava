package name.hanyi.unitsconversion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnitsConversionTest {

    UnitsConversion unitsConversion;

    @Before
    public void setUp() {
        unitsConversion = new UnitsConversion();
    }

    @Test
    public void getKilogramsByGivenPounds() {
        assertThat(unitsConversion.get(1), is(0.45359237D));
        assertThat(unitsConversion.get(1.5D), is(0.68038856D));
    }
}

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
        unitsConversion.setUnits("pound", "kilogram");
        assertThat(unitsConversion.get(1).doubleValue(), is(0.45359237D));
        assertThat(unitsConversion.get(1.5D).doubleValue(), is(0.68038856D));
        assertThat(unitsConversion.get(100D).doubleValue(), is(45.359237D));
    }

    @Test
    public void getCentimetersByGivenInches() {
        unitsConversion.setUnits("inch", "cm");
        assertThat(unitsConversion.get(1).doubleValue(), is(2.54D));
    }
}

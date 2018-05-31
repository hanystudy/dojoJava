package name.hanyi.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void getExactlySameOutputForNormalInput() {
        assertThat(fizzBuzz.get(1), is("1"));
    }
}

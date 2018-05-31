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

    @Test
    public void getFizzForNumberDivisibleByThree() {
        assertThat(fizzBuzz.get(3), is("Fizz"));
        assertThat(fizzBuzz.get(6), is("Fizz"));
        assertThat(fizzBuzz.get(9), is("Fizz"));
    }

    @Test
    public void getBuzzForNumberDivisibleByFive() {
        assertThat(fizzBuzz.get(5), is("Buzz"));
        assertThat(fizzBuzz.get(10), is("Buzz"));
        assertThat(fizzBuzz.get(25), is("Buzz"));
    }
}

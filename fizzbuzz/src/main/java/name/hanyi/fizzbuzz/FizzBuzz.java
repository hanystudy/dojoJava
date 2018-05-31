package name.hanyi.fizzbuzz;

public class FizzBuzz {
    public String get(int number) {
        if (isDivisibleBy(number, 5) && isDivisibleBy(number, 3)) {
            return "FizzBuzz";
        }
        if (isDivisibleBy(number, 5)) {
            return "Buzz";
        }
        if (isDivisibleBy(number, 3)) {
            return "Fizz";
        }
        return String.valueOf(number);
    }

    private boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}

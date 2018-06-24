package name.hanyi.fizzbuzz;

import name.hanyi.fizzbuzz.annotation.Author;

@Author(
    date = "06/24/2018"
)
public class FizzBuzz {
    public String get(int number) {
        if (isDivisibleBy(number, 5) && isDivisibleBy(number, 3)) {
            return "FizzBuzz";
        }
        if (isDivisibleBy(number, 5) || isContains(number, "5")) {
            return "Buzz";
        }
        if (isDivisibleBy(number, 3) || isContains(number, "3")) {
            return "Fizz";
        }
        return String.valueOf(number);
    }

    private boolean isContains(int number, String s) {
        return String.valueOf(number).contains(s);
    }

    private boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}

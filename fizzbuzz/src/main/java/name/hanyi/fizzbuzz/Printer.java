package name.hanyi.fizzbuzz;

public class Printer {
    public void print(int min, int max) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        for(int num = min; num <= max; num++) {
            System.out.println(fizzBuzz.get(num));
        }
    }
}

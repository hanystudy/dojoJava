package name.hanyi.fizzbuzz.annotation;

public @interface Author {
    String name() default "Han Yi";
    String date();
}

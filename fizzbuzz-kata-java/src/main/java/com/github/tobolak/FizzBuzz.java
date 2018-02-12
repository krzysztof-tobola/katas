package com.github.tobolak;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

class FizzBuzz {

    public List<String> generate() {
        return rangeClosed(1, 100)
                .mapToObj(this::fizzBuzz)
                .collect(toList());
    }

    private String fizzBuzz(int x) {
        return isFizz(x) && isBuzz(x) ? "FizzBuzz"
                : isFizz(x) ? "Fizz"
                : isBuzz(x) ? "Buzz"
                : String.valueOf(x);
    }

    private boolean isBuzz(int number) {
        return divisibleByOrContains(number, 5);
    }

    private boolean isFizz(int number) {
        return divisibleByOrContains(number, 3);
    }

    private static boolean divisibleByOrContains(int number, int divisor) {
        return number % divisor == 0 || String.valueOf(number).contains(String.valueOf(divisor));
    }
}

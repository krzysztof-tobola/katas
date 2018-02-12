package com.github.tobolak;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class FizzBuzzTest {

    @Test
    public void shouldGenerateHundredItems() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.generate(), hasSize(100));
        assertThat(fizzBuzz.generate(), hasAt(1, "1"));
        assertThat(fizzBuzz.generate(), hasAt(2, "2"));
        assertThat(fizzBuzz.generate(), hasAt(3, "Fizz"));
        assertThat(fizzBuzz.generate(), hasAt(5, "Buzz"));
        assertThat(fizzBuzz.generate(), hasAt(6, "Fizz"));
        assertThat(fizzBuzz.generate(), hasAt(10, "Buzz"));
        assertThat(fizzBuzz.generate(), hasAt(15, "FizzBuzz"));
        assertThat(fizzBuzz.generate(), hasAt(30, "FizzBuzz"));
        assertThat(fizzBuzz.generate(), hasAt(13, "Fizz"));
        assertThat(fizzBuzz.generate(), hasAt(23, "Fizz"));
        assertThat(fizzBuzz.generate(), hasAt(52, "Buzz"));
        assertThat(fizzBuzz.generate(), hasAt(56, "Buzz"));
        assertThat(fizzBuzz.generate(), hasAt(53, "FizzBuzz"));
    }

    private static <T> Matcher<List<T>> hasAt(int position, T item) {
        return new CustomTypeSafeMatcher<List<T>>("List with item " + position + " equal to " + item) {
            @Override
            protected boolean matchesSafely(List<T> list) {
                return list.get(position - 1).equals(item);
            }

            @Override
            protected void describeMismatchSafely(List<T> list, Description description) {
                description.appendText("item " + position + " was ")
                        .appendValue(list.get(position - 1));
            }
        };
    }
}

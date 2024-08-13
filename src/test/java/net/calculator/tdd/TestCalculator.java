package net.calculator.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCalculator {

    @Test
    public void testCalculator() {
        assertEquals(0, add(""));
        assertEquals(1, add("1"));
        assertEquals(6, add("1,5"));
    }

    int add(final String numbers) {
        if (numbers == null || numbers.strip().isBlank()) {
            return 0;
        }

        return Integer.valueOf(numbers);
    }
}

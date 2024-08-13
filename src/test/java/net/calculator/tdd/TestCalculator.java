package net.calculator.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TestCalculator {

    @Test
    public void testCalculator() {
        assertEquals(0, add(""));
        assertEquals(1, add("1"));
        assertEquals(6, add("1,5"));
        assertEquals(8, add("1,2,5"));
        assertEquals(8, add("1\n2,5"));
        assertEquals(10, add("1\n2,5,,\n2"));
        assertEquals(3, add("//;\n1;2"));
    }

    int add(final String numbers) {
        if (numbers == null || numbers.strip().isBlank()) {
            return 0;
        }

        String delimiter = "";
        String intString = numbers;

        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));
            intString = numbers.split("//" + delimiter + "\\n")[1];
        } else {
            delimiter = "[,\\n]";
        }
        final String tokens[] = intString.split(delimiter);
        final int sum = Arrays.stream(tokens).mapToInt(token -> {
            int intToken = 0;
            try {
                intToken = Integer.valueOf(token);
            } catch (NumberFormatException nfe) {
                System.err.println("The token '" + token + "' may not be parsed to integer !");
            }
            return intToken;
        }).sum();

        return sum;
    }
}

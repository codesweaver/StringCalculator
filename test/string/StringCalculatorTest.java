package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator cal;

    @BeforeEach
    void setup() {
        cal = new StringCalculator();
    }

    @Test
    void parse() {
        String input = "//@\n1@2@3@4";
        List<String> inputs = cal.parse(input);
        assertEquals(inputs.get(0), "@");
        assertEquals(inputs.get(1), "1@2@3@4");
    }

    @Test
    void parseToInt() {
        List<String> inputs = new ArrayList<>();
        inputs.add(",|;");
        inputs.add("1,2;3");

        List<Integer> numbers = cal.parseToInt(inputs);
        assertEquals(numbers.size(), 3);
        assertEquals(numbers.get(numbers.size()-1), 3);

        inputs = new ArrayList<>();
        inputs.add("@");
        inputs.add("1@2@3@4");

        numbers = cal.parseToInt(inputs);
        assertEquals(numbers.size(), 4);
        assertEquals(numbers.get(numbers.size()-1), 4);
    }

    @Test
    void sum() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        int result = cal.sum(numbers);
        assertEquals(result, 55);
    }
}
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
        //when
        String input = "//@\n1@2@3@4";

        //given
        List<String> inputs = cal.parse(input);

        //then
        assertEquals(inputs.get(0), "@");
        assertEquals(inputs.get(1), "1@2@3@4");
    }

    @Test
    void parseToInt() {
        //when
        List<String> inputs = new ArrayList<>();
        inputs.add(",|;");
        inputs.add("1,2;3");

        //given
        List<Integer> numbers = cal.parseToInt(inputs);

        //then
        assertEquals(numbers.size(), 3);
        assertEquals(numbers.get(numbers.size()-1), 3);

        //when
        inputs = new ArrayList<>();
        inputs.add("@");
        inputs.add("1@2@3@4");

        //given
        numbers = cal.parseToInt(inputs);

        //then
        assertEquals(numbers.size(), 4);
        assertEquals(numbers.get(numbers.size()-1), 4);
    }

    @Test
    void sum() {
        //when
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i+1);
        }

        //given
        int result = cal.sum(numbers);

        //then
        assertEquals(result, 55);
    }
}
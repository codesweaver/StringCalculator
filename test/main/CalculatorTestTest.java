package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestTest {

    Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
        System.out.println("BeforeEach.called");
    }

    @AfterEach
    void clean() {
        System.out.println("AfterEach.called");
    }

    @Test
    void 덧셈() {
        assertEquals(6, cal.add(5, 1));
        System.out.println("Add");
    }

    @Test
    void 뺄셈() {
        assertEquals(6, cal.subtract(9, 3));
        System.out.println("Subtract");
    }

    @Test
    void 곱셈() {
        assertEquals(27, cal.multiply(3, 9));
        System.out.println("Multiply");
    }

    @Test
    void 나눗셈() {
        assertEquals(3, cal.divide(9, 3));
        System.out.println("Divide");
    }
}
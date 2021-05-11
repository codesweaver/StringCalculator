package main;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        add(cal);
        subtract(cal);
        multiply(cal);
        divide(cal);
    }

    public static void add(Calculator cal) {
        System.out.println(cal.add(9, 3));
    }

    public static void subtract(Calculator cal) {
        System.out.println(cal.subtract(9, 3));
    }

    public static void multiply(Calculator cal) {
        System.out.println(cal.multiply(9, 3));
    }

    public static void divide(Calculator cal) {
        System.out.println(cal.divide(9, 3));
    }
}

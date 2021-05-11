package string;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void stringSeperate() {
        String s = "1,2;3";
        String[] inputs = s.split("[,;]");
        assertEquals(3, inputs.length);
    }

    @Test
    void rexExpr() {
        String s = "//;\n1;2;3";
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(s);

        String seperator = "[,;]";
        if (matcher.find()) {
            seperator = matcher.group();
            System.out.println(seperator);
            // seperator = seperator.replace("//", "");
        }
        // System.out.println(seperator);
    }

    @Test
    void add() {
        StringCalculator cal = new StringCalculator();
        assertEquals(6, cal.add("1,2;3"));
        assertEquals(6, cal.add("//;\n1;2;3"));
    }
}
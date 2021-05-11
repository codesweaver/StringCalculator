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
        String seperator = "[,;]";

        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));

            seperator = matcher.group(1);
            s = matcher.group(2);
            seperator = seperator.replace("//", "").trim();
        }
    }

    @Test
    void add() {
        StringCalculator cal = new StringCalculator();
        assertEquals(6, cal.add("1,2;3"));
        assertEquals(6, cal.add("//@\n1@2@3"));
        assertEquals(6, cal.add("//;\n1;2;3"));
        assertThrows(RuntimeException.class, ()-> {
            // cal.add("-1");
            // cal.add("1, 2, -1");
            cal.add("//@\n1@2@-3");
        });
    }
}
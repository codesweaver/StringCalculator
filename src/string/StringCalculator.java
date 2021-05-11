package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int[] parseString(String input) {

        String seperator = getSeperator(input);
        String[] inputs = input.split(seperator);
        int[] numbers = new int[inputs.length];

        for (int i=0; i<inputs.length; i++) {
            int number = Integer.parseInt(inputs[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    public String getSeperator(String input) {
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        String result = "[,;]";
        if (matcher.find()) {
            result = matcher.group();
            result = result.replace("//", "");
        }
        return result;
    }

    public int add(String input) {
        int[] numbers = parseString(input);
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}

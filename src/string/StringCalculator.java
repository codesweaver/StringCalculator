package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int[] parseString(String input) {

        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        String seperator = "[,;]";
        if (matcher.find()) {
            seperator = matcher.group(1);
            input = matcher.group(2);
        }

        return getIntegerArray(seperator, input);
    }

    public int[] getIntegerArray(String seperator, String input) {

        String[] inputs = input.split(seperator);
        int[] numbers = new int[inputs.length];

        for (int i=0; i<inputs.length; i++) {
            int number = Integer.parseInt(inputs[i]);
            if (number < 0) throw new RuntimeException("음수를 입력할 수 없습니다");
            numbers[i] = number;
        }
        return numbers;
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

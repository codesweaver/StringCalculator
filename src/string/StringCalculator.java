package string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public List<String> parse(String input) {

        List<String> results = new ArrayList<>();
        results.add(",|;");
        results.add(input);

        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            results.add(0, matcher.group(1));
            results.add(1, matcher.group(2));
        }

        return results;
    }

    public List<Integer> parseToInt(List<String> inputs) {

        String[] data = inputs.get(1).split(inputs.get(0));
        List<Integer> numbers = new ArrayList<>();

        for (String value : data) {
            int number = Integer.parseInt(value.trim());
            if (number < 0) throw new RuntimeException("음수를 입력할 수 없습니다");
            numbers.add(number);
        }
        return numbers;
    }

    public int add(String input) {

        if (input == null) return 0;
        if (input.isEmpty()) return 0;

        List<String> inputs = parse(input);
        List<Integer> numbers = parseToInt(inputs);

        return sum(numbers);
    }

    public int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}

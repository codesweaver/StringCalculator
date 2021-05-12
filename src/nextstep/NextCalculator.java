package nextstep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NextCalculator {
    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toIntArray(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private int[] toIntArray(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = getPositive(tokens[i]);
        }
        return numbers;
    }

    private int getPositive(String token) {
        int number = Integer.parseInt(token);
        if (number < 0 ){
            throw new RuntimeException("음수를 입력할 수 없습니다");
        }
        return number;
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split("[,;]");
    }
}

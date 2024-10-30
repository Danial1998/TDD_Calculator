import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(\\[(.+?)\\]|([^\\n]+))\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                if (matcher.group(2) != null) {
                    delimiter = Pattern.quote(matcher.group(2));
                } else {
                    delimiter = Pattern.quote(matcher.group(3));
                }
                numberString = matcher.group(4); // Remaining numbers
            }
        }

        String[] tokens = numberString.split(delimiter);

        var negatives = Arrays.stream(tokens)
                .mapToInt(num->Integer.parseInt(num))
                .filter(num -> num < 0)
                .boxed()
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            throw new RuntimeException("negatives not allowed: " + negatives);
        }

        return Arrays.stream(tokens)
                .mapToInt(num->Integer.parseInt(num))
                .filter(num->num<=1000)
                .sum();
    }

    public int GetCalledCount() {
        return callCount;
    }
}

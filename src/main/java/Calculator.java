import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                numberString = matcher.group(2);
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
                .sum();
    }
}

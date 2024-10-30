import java.util.Arrays;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        return Arrays.stream(numbers.split(","))
                .mapToInt(num -> Integer.parseInt(num))
                .sum();
    }

}

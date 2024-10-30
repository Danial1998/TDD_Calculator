import java.util.Arrays;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.replace("\n", ",").split(",");
        return Arrays.stream(tokens)
                .mapToInt(num -> Integer.parseInt(num))
                .sum();
    }

}

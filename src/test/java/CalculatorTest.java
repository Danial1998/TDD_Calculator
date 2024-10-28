import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testEmptyStringReturnsZero(){
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldReturnNumberForSingleNumber(){
        Calculator calculator = new Calculator();
        assertEquals(1,calculator.add("1"));
    }

    @Test
    public void shouldReturnSumForTwoNumbersDelimitedByComma(){
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add("1,2"));
    }
}

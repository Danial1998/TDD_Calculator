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

    @Test
    public void shouldReturnSumForMultipleNumbers(){
        Calculator calculator = new Calculator();
        assertEquals(10,calculator.add("1,2,3,4"));
    }

    @Test
    public void shouldAcceptNewlineAsValidDelimiter(){
        Calculator calculator = new Calculator();
        assertEquals(6,calculator.add("1\n2,3"));
    }

    @Test
    public void shouldAcceptCustomDelimiterSyntax(){
        Calculator calculator = new Calculator();
        assertEquals(3,calculator.add("//;\n1;2"));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenForEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even.");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenForOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd.");
    }
}

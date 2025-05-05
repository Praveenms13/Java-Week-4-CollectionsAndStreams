import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    public void testDivideByZero() {
        MathUtils mathUtils = new MathUtils();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testDivideNormal() {
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.divide(10, 2);
        assertEquals(5, result);
    }
}

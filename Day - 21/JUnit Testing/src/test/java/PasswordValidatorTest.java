import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    public void testShortPassword() {
        assertFalse(validator.isValid("P1a"));
    }

    @Test
    public void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private final UserRegistration reg = new UserRegistration();

    @Test
    public void testValidRegistration() {
        String result = reg.registerUser("john_doe", "john@example.com", "secure123");
        assertEquals("User registered successfully", result);
    }

    @Test
    public void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            reg.registerUser("", "john@example.com", "secure123");
        });
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            reg.registerUser("john_doe", "invalid-email", "secure123");
        });
    }

    @Test
    public void testShortPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            reg.registerUser("john_doe", "john@example.com", "123");
        });
    }
}

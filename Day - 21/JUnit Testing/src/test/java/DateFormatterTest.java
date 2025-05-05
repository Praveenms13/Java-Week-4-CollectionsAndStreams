import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    private final DateFormatter formatter = new DateFormatter();

    @Test
    public void testValidDate() {
        assertEquals("05-05-2025", formatter.formatDate("2025-05-05"));
        assertEquals("01-01-2000", formatter.formatDate("2000-01-01"));
    }

    @Test
    public void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("05/05/2025");
        });
    }

    @Test
    public void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2025-13-40");
        });
    }
}

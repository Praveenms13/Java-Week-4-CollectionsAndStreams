import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils stringUtils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("edcba", stringUtils.reverse("abcde"));
        assertEquals("98765", stringUtils.reverse("56789"));
        assertNull(stringUtils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("java"));
        assertNull(stringUtils.toUpperCase(null));
    }
}

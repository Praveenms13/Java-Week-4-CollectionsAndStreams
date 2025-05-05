import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list));
        assertTrue(list.contains(5));
    }

    @Test
    public void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.removeElement(list, 10);
        assertEquals(0, listManager.getSize(list));
        assertFalse(list.contains(10));
    }

    @Test
    public void testGetSize() {
        listManager.addElement(list, 1);
        listManager.addElement(list, 2);
        listManager.addElement(list, 3);
        assertEquals(3, listManager.getSize(list));
    }
}

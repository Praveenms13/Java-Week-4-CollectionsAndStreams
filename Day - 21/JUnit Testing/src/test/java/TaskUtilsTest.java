import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class TaskUtilsTest {

    private final TaskUtils taskUtils = new TaskUtils();

    @Test
    public void testLongRunningTask() {
        String result = assertTimeout(Duration.ofSeconds(5), () -> taskUtils.longRunningTask());
        assertEquals("Task completed", result);
    }
}

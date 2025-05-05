import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected(), "Connection should be established.");
    }

    @Test
    public void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected(), "Connection should be closed.");
    }
}

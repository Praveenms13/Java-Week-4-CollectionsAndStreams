import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {

    private FileProcessor processor;
    private final String testFile = "testfile.txt";

    @BeforeEach
    public void setup() {
        processor = new FileProcessor();
    }

    @AfterEach
    public void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(testFile));
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, File!";
        processor.writeToFile(testFile, content);
        String result = processor.readFromFile(testFile);
        assertEquals(content, result);
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(testFile, "Checking existence");
        assertTrue(Files.exists(Path.of(testFile)));
    }

    @Test
    public void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> processor.readFromFile("nonexistent.txt"));
    }
}

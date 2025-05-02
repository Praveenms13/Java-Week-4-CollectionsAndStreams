import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class LargeFileGenerator {
    public static void main(String[] args) {
        String fileName = "largefile.dat";
        int fileSizeMB = 100; // 100 MB
        int totalBytes = fileSizeMB * 1024 * 1024;

        byte[] buffer = new byte[4096];
        Random random = new Random();

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            for (int i = 0; i < totalBytes / buffer.length; i++) {
                random.nextBytes(buffer);
                fos.write(buffer);
            }
            System.out.println("Generated file: " + fileName + " (" + fileSizeMB + "MB)");
        } catch (IOException e) {
            System.out.println("Error generating file: " + e.getMessage());
        }
    }
}

import java.io.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImage = "original.png";
        String outputImage = "copied.png";

        try {
            byte[] imageBytes = readImageToByteArray(sourceImage);
            writeByteArrayToImage(imageBytes, outputImage);
            boolean isIdentical = compareFiles(sourceImage, outputImage);
            System.out.println("Files are identical: " + isIdentical);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    public static byte[] readImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static boolean compareFiles(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            int b1, b2;
            do {
                b1 = fis1.read();
                b2 = fis2.read();
                if (b1 != b2) return false;
            } while (b1 != -1 && b2 != -1);

            return b1 == b2;
        }
    }
}

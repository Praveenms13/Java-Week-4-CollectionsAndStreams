import java.io.*;

public class BufferedVsUnbufferedCopy {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destUnbuffered = "copy_unbuffered.dat";
        String destBuffered = "copy_buffered.dat";

        long unbufferedTime = copyUnbuffered(sourceFile, destUnbuffered);
        System.out.println("Unbuffered copy time: " + unbufferedTime + " ns");

        long bufferedTime = copyBuffered(sourceFile, destBuffered);
        System.out.println("Buffered copy time: " + bufferedTime + " ns");

        System.out.printf("Buffered stream was %.2f times faster than unbuffered.\n",
                (double) unbufferedTime / bufferedTime);
    }

    public static long copyUnbuffered(String source, String dest) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    public static long copyBuffered(String source, String dest) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}

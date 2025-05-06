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

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                System.out.println("Error while closing streams: " + ex.getMessage());
            }
        }

        return System.nanoTime() - startTime;
    }


    public static long copyBuffered(String source, String dest) {
        long startTime = System.nanoTime();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(source));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException ex) {
                System.out.println("Error while closing buffered streams: " + ex.getMessage());
            }
        }

        return System.nanoTime() - startTime;
    }

}

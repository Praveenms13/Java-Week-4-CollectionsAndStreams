import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();

        try {
            pis.connect(pos);

            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static class Writer implements Runnable {
        private PipedOutputStream pos;

        public Writer(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                String message = "Hello from writer thread!";
                pos.write(message.getBytes());
                pos.close();
                System.out.println("Writer thread: Data written to PipedOutputStream.");
            } catch (IOException e) {
                System.out.println("Writer thread error: " + e.getMessage());
            }
        }
    }

    static class Reader implements Runnable {
        private PipedInputStream pis;

        public Reader(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead = pis.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Reader thread: Data read from PipedInputStream: " + message);
                pis.close();
            } catch (IOException e) {
                System.out.println("Reader thread error: " + e.getMessage());
            }
        }
    }
}

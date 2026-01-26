import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

    static class WriterThread extends Thread {
        private final PipedOutputStream pos;

        public WriterThread(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                String message = "Hello Reader! This data is sent using Piped Streams.\n";

                for (char ch : message.toCharArray()) {
                    pos.write(ch);
                    Thread.sleep(50);
                }

                pos.flush();
                System.out.println("✅ Writer finished writing.");

            } catch (IOException | InterruptedException e) {
                System.out.println("Writer Error: " + e.getMessage());
            } finally {
                try {
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Error closing PipedOutputStream: " + e.getMessage());
                }
            }
        }
    }

    static class ReaderThread extends Thread {
        private final PipedInputStream pis;

        public ReaderThread(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try {
                int data;
                System.out.println("Reader started reading...\n");

                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }

                System.out.println("\n Reader finished reading.");

            } catch (IOException e) {
                System.out.println("Reader Error: " + e.getMessage());
            } finally {
                try {
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Error closing PipedInputStream: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();

            pos.connect(pis);

            ReaderThread reader = new ReaderThread(pis);
            WriterThread writer = new WriterThread(pos);

            reader.start();
            Thread.sleep(100);
            writer.start();

            writer.join();
            reader.join();

            System.out.println("\n Inter-thread communication completed successfully!");

        } catch (IOException e) {
            System.out.println("IOException while connecting streams: " + e.getMessage());

        } catch (InterruptedException e) {
            System.out.println("Thread interruption error: " + e.getMessage());
        }
    }
}

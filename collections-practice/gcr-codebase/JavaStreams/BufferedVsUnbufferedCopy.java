import java.io.*;

public class BufferedVsUnbufferedCopy {

    private static final int BUFFER_SIZE = 4096; 

    public static void copyUnbuffered(String source, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error in Unbuffered Copy: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + ((endTime - startTime) / 1_000_000.0) + " ms");
    }

    public static void copyBuffered(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.flush();

        } catch (IOException e) {
            System.out.println("Error in Buffered Copy: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered Copy Time  : " + ((endTime - startTime) / 1_000_000.0) + " ms");
    }

    public static void main(String[] args) {

        String sourceFile = "largeFile.dat";
        String unbufferedDest = "copy_unbuffered.dat";
        String bufferedDest = "copy_buffered.dat";

        System.out.println("Copying File: " + sourceFile);
        System.out.println("--------");

        copyUnbuffered(sourceFile, unbufferedDest);
        copyBuffered(sourceFile, bufferedDest);

        System.out.println("--------");
        System.out.println("Comparison Completed!");
    }
}

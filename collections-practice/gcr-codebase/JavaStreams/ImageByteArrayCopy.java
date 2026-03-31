import java.io.*;
import java.util.Arrays;

public class ImageByteArrayCopy {

    public static void main(String[] args) {

        String sourceImage = "original.jpg";
        String copiedImage = "copied.jpg"; 

        try {
            byte[] imageBytes = fileToByteArray(sourceImage);
            System.out.println("Image converted to byte array. Total bytes: " + imageBytes.length);

            byteArrayToFile(imageBytes, copiedImage);
            System.out.println("Byte array written to new file: " + copiedImage);

            boolean identical = verifyFilesIdentical(sourceImage, copiedImage);

            if (identical) {
                System.out.println("Verification Passed: Both images are IDENTICAL");
            } else {
                System.out.println("Verification Failed: Images are NOT identical");
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    private static byte[] fileToByteArray(String filePath) throws IOException {

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

    // ✅ Convert byte[] -> file using ByteArrayInputStream
    private static void byteArrayToFile(byte[] data, String outputPath) throws IOException {

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // ✅ Verify both files are exactly same (byte-by-byte)
    private static boolean verifyFilesIdentical(String file1, String file2) throws IOException {

        byte[] bytes1 = fileToByteArray(file1);
        byte[] bytes2 = fileToByteArray(file2);

        return Arrays.equals(bytes1, bytes2);
    }
}

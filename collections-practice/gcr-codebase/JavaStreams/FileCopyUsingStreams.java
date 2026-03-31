import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyUsingStreams {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);

        } catch (IOException e) {
            System.out.println("IOException occurred while copying file.");
            e.printStackTrace();

        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing the file streams.");
            }
        }
    }
}

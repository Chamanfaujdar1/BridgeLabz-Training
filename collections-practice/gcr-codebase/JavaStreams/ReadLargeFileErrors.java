import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFileErrors {

    public static void main(String[] args) {

        String filePath = "large_log.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath), 64 * 1024)) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

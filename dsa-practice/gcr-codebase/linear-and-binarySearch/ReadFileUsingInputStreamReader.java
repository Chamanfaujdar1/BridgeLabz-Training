import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFileUsingInputStreamReader {
    public static void main(String[] args) {

        String filePath = "input.txt";

        try {
            FileInputStream fis = new FileInputStream(filePath);

            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } 
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UpperToLowerFileCopy {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8)
                );

                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(destinationFile), StandardCharsets.UTF_8)
                )
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();        
            }

            System.out.println("File copied successfully with uppercase converted to lowercase!");
            System.out.println("Output File: " + destinationFile);

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}

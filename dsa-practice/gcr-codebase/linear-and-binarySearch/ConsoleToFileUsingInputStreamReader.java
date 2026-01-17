import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConsoleToFileUsingInputStreamReader {
    public static void main(String[] args) {

        String filePath = "output.txt";

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter(filePath);

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (true) {
                line = br.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(line + "\n");
            }

            fw.close();
            System.out.println("✅ Data saved to file: " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

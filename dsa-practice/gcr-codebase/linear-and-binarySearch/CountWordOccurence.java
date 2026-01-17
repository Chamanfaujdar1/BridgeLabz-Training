import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrence {
    public static void main(String[] args) {

        String filePath = "input.txt";
        String targetWord = "java";

        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\W+");

                for (String w : words) {
                    if (w.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();

            System.out.println("Word \"" + targetWord + "\" occurred: " + count + " times");
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
